package com.example.securityapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity {

    TextInputEditText emailEditText;
    Button btn_reset;
    TextView resetText;
    Validation validate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        FirebaseApp.initializeApp(this);
        final FirebaseAuth mAuth= FirebaseAuth.getInstance();

        emailEditText=findViewById(R.id.editTextEmail);
        btn_reset=findViewById(R.id.resetPasswordButton);
        resetText=findViewById(R.id.resetPasswordText);
        validate= new Validation();

        btn_reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email= emailEditText.getEditableText().toString().trim();
                if(validate.validateEmail(emailEditText)){
                    mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ResetPasswordActivity.this,"EMAIL SENT. PLEASE CHECK YOUR MAIL",Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(ResetPasswordActivity.this,MainActivity.class));
                                ResetPasswordActivity.this.finish();
                            }
                            else
                            {
                                String error = task.getException().getMessage();
                                Toast.makeText(ResetPasswordActivity.this,error,Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });

    }
}