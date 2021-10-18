package com.example.appdroid.ui.home;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.appdroid.R;

public class life_at_nit extends AppCompatActivity {

    CardView utub1,utub2,utub3,utub4,utub5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_at_nit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Life at HIT");

        utub1= findViewById(R.id.utub1);
        utub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                watchYoutubeVideo("https://www.youtube.com/watch?v=Qzgb4wo_yEA&t=2s");
            }
        });

        utub2= findViewById(R.id.utub2);
        utub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                watchYoutubeVideo("https://www.youtube.com/watch?v=7_UQvI3rwOA");
            }
        });

        utub3= findViewById(R.id.utub3);
        utub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                watchYoutubeVideo("https://www.youtube.com/watch?v=oD2QkFlSopU");
            }
        });

        utub4= findViewById(R.id.utub4);
        utub4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                watchYoutubeVideo("https://www.youtube.com/watch?v=VY14dHyy9Dg");
            }
        });

        utub5= findViewById(R.id.utub5);
        utub5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                watchYoutubeVideo("https://www.youtube.com/watch?v=IkhF3Bksxj8");
            }
        });

    }

    public void watchYoutubeVideo(String id) {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(id));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }
}