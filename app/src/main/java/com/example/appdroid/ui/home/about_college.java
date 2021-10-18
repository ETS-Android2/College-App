package com.example.appdroid.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.appdroid.R;

public class about_college extends AppCompatActivity {


    //CardView map;
    ImageView map;
    CardView gmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_college);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About college");

        gmail= findViewById(R.id.mail);
        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("admin@heritageit.edu");
            }
        });

        map=findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

    }

    private void openMap() {
        Uri uri= Uri.parse("geo:0, 0?q=Heritage institute of technology, kolkata");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
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