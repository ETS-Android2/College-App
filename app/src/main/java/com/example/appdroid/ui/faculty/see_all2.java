package com.example.appdroid.ui.faculty;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.appdroid.R;

public class see_all2 extends AppCompatActivity {

    CardView wA1,wA2,wA3,wA4,wA5,wA6,wA7,wA8,wA9,wA10,wA11,wA12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all2);
        getSupportActionBar().setTitle("Important groups");

        wA1= findViewById(R.id.wA1);
        wA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWAgrp("https://chat.whatsapp.com/GAJb5zOpDss3Q7arFHfOKN");
            }
        });
        wA2= findViewById(R.id.wA2);
        wA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTLgrp("https://t.me/joinchat/M3dUQU3DWVvuCk8rdReIpg");
            }
        });

    }

    private void openWhatsapp(String num) {
        try {
            String headerReceiver = "hello";// Replace with your message.
            String bodyMessageFormal = "hello2";// Replace with your message.
            String whatsappContain = headerReceiver + bodyMessageFormal;
            String trimToNumner = num; //10 digit number
            Intent intent = new Intent ( Intent.ACTION_VIEW );
            intent.setData ( Uri.parse ( "https://wa.me/" + trimToNumner + "/?text=" + "" ) );
            startActivity ( intent );
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    private void openWAgrp(String link){
        Intent intentWhatsapp = new Intent(Intent.ACTION_VIEW);
        String url = link;
        intentWhatsapp.setData(Uri.parse(url));
        intentWhatsapp.setPackage("com.whatsapp");
        startActivity(intentWhatsapp);
    }

    private void openTLgrp(String link){
        Intent intenttele = new Intent(Intent.ACTION_VIEW);
        String url = link;
        intenttele.setData(Uri.parse(url));
        intenttele.setPackage("org.telegram.messenger");
        startActivity(intenttele);
    }
}