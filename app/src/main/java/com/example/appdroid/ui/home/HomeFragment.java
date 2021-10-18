package com.example.appdroid.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.appdroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;


public class HomeFragment extends Fragment {
    CardView aboutCollege,lifeAtNit,placements,facilities,placesNearBy,web,cont;
    private SliderLayout sliderLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout= view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2);


        aboutCollege= (CardView) view.findViewById(R.id.aboutCollege);
        web= (CardView) view.findViewById(R.id.web);
        cont= (CardView) view.findViewById(R.id.cont);
        lifeAtNit= (CardView) view.findViewById(R.id.lifeAtNit);
        placements= (CardView) view.findViewById(R.id.placements);
        facilities= (CardView) view.findViewById(R.id.facilities);
        placesNearBy= (CardView) view.findViewById(R.id.placesNearBy);



        aboutCollege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), about_college.class);
                startActivity(intent);
            }
        });

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("balaa5884@gmail.com");

            }
        });

        lifeAtNit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), life_at_nit.class);
                startActivity(intent);
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.heritageit.edu/"));
                startActivity(intent);
            }
        });

        placements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), placements.class);
                startActivity(intent);
            }
        });

        facilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), facility.class);
                startActivity(intent);
            }
        });

        placesNearBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), places_near_by.class);
                startActivity(intent);
            }
        });


        setSliderViews();
        return view;
    }

    private void openGmail(String email) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        String[] recipients = {email};//Add multiple recipients here
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        //intent.putExtra(Intent.EXTRA_SUBJECT, "Mail Subject"); //Add Mail Subject
        intent.putExtra(Intent.EXTRA_TEXT, "Hello ma'am!!");//Add mail body
        //intent.putExtra(Intent.EXTRA_CC, "mailcc@gmail.com");//Add CC emailid's if any
        //intent.putExtra(Intent.EXTRA_BCC, "mailbcc@gmail.com");//Add BCC email id if any
        intent.setType("text/html");
        intent.setPackage("com.google.android.gm");//Added Gmail Package to forcefully open Gmail App
        startActivity(Intent.createChooser(intent, "Send mail"));
    }


    private void setSliderViews() {
        for(int i =0; i<5;i++){
            DefaultSliderView sliderView= new DefaultSliderView(getContext());


            switch(i){
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/myapp-b5ea4.appspot.com/o/4.jpg?alt=media&token=73d50af9-6437-4317-9427-d19703b36c29");
                    break;
                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/myapp-b5ea4.appspot.com/o/1.jpg?alt=media&token=bf628902-c6c0-4572-a69e-3b1f1a6d7b65");
                    break;
                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/myapp-b5ea4.appspot.com/o/2.jpg?alt=media&token=e40c6bff-82ee-4d24-ba13-c6a459ca926a");
                    break;
                case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/myapp-b5ea4.appspot.com/o/5.jpg?alt=media&token=f3e8e840-43d9-465a-9fa1-a2228725890c");
                    break;
                case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/myapp-b5ea4.appspot.com/o/3.jpg?alt=media&token=4f7421e7-0528-4063-a83d-3bf788f8b24d");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);
        }
    }

}