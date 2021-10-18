package com.example.appdroid.ui.faculty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.appdroid.R;

public class see_all1 extends AppCompatActivity {

    CardView wa2,wa3,wa4,wa5,wa6,wa7,wa8,wa9,wa10,wa11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all1);
        getSupportActionBar().setTitle("Professors");

        wa2= findViewById(R.id.wa2);
        wa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("amitava.bagchi@heritageit.edu");
            }
        });

        wa3= findViewById(R.id.wa3);
        wa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("subhashis.majumder@heritageit.edu");
            }
        });

        wa4= findViewById(R.id.wa4);
        wa4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("poulami.das@heritageit.edu");
            }
        });

        wa5= findViewById(R.id.wa5);
        wa5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("prosenjit.gupta@heritageit.edu");
            }
        });

        wa6= findViewById(R.id.wa6);
        wa6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("aniruddha.dasgupta@heritageit.edu");
            }
        });

        wa7= findViewById(R.id.wa7);
        wa7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("kamal.poddar@heritageit.edu");
            }
        });

        wa8= findViewById(R.id.wa8);
        wa8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("dinabandhu.bhandari@heritageit.edu");
            }
        });

        wa9= findViewById(R.id.wa9);
        wa9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("mohuya.byabartta@heritageit.edu");
            }
        });

        wa10= findViewById(R.id.wa10);
        wa10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("Arindam.Chatterjee@heritageit.edu");
            }
        });

        wa11= findViewById(R.id.wa11);
        wa11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("sujay.saha@heritageit.edu");
            }
        });


    }

    private void openGmail(String email) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        String[] recipients = {email};//Add multiple recipients here
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        //intent.putExtra(Intent.EXTRA_SUBJECT, "Mail Subject"); //Add Mail Subject
        intent.putExtra(Intent.EXTRA_TEXT, "Hello sir!!");//Add mail body
        //intent.putExtra(Intent.EXTRA_CC, "mailcc@gmail.com");//Add CC emailid's if any
        //intent.putExtra(Intent.EXTRA_BCC, "mailbcc@gmail.com");//Add BCC email id if any
        intent.setType("text/html");
        intent.setPackage("com.google.android.gm");//Added Gmail Package to forcefully open Gmail App
        startActivity(Intent.createChooser(intent, "Send mail"));
    }
}