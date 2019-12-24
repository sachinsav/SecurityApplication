package com.example.securityapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class setting_fragment extends Fragment {
    Button sos;
    Button rate_us,scream,invite;
    String str="Check out TRATA, I use it to protect myself and the people I care about. Get it for free at \nhttps://play.google.com/store/apps/details?id=com.android.chrome";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_setting,container,false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rate_us=getActivity().findViewById(R.id.rate_us);
        scream=getActivity().findViewById(R.id.screem);
        invite=getActivity().findViewById(R.id.invite);
        scream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "This feature are Comming Soon...", Toast.LENGTH_SHORT).show();
            }
        });
        rate_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Uri uri = Uri.parse("market://details?id="+"com.android.chrome");
                    Intent Rate = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(Rate);
                }
                catch (ActivityNotFoundException e)
                {
                    Uri uri = Uri.parse("https://play.google.com/store/apps/details?id="+"com.android.chrome");
                    Intent Rate = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(Rate);
                }
            }
        });
        invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,str);
                intent.putExtra(Intent.EXTRA_SUBJECT,"TRATA : THE SECURITY APPLICATION");
                intent.setType("text/plain");
                startActivity(intent);
            }
        });
    }
}
