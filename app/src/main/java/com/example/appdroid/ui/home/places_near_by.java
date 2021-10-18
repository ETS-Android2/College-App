package com.example.appdroid.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.appdroid.R;

public class places_near_by extends AppCompatActivity implements View.OnClickListener {

    private CardView acro, sci,urbana,mani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_near_by);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Places near by");


        acro = findViewById(R.id.acro);
        acro.setOnClickListener(this);
        sci= findViewById(R.id.sci);
        sci.setOnClickListener(this);
        urbana= findViewById(R.id.urbana);
        urbana.setOnClickListener(this);
        mani= findViewById(R.id.mani);
        mani.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.urbana:
                Uri uri2 = Uri.parse("geo:0, 0?q=Urbana NRI complex, kolkata");
                intent = new Intent(Intent.ACTION_VIEW, uri2);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
                break;

            case R.id.mani:
                Uri uri3 = Uri.parse("geo:0, 0?q=Mani square, kolkata");
                intent = new Intent(Intent.ACTION_VIEW, uri3);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
                break;

            case R.id.acro:
                Uri uri = Uri.parse("geo:0, 0?q=Acropolis mall,kolkata");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
                break;

            case R.id.sci:
                Uri uri1 = Uri.parse("geo:0, 0?q=Science city, kolkata");
                intent = new Intent(Intent.ACTION_VIEW, uri1);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
                break;
        }
    }
}