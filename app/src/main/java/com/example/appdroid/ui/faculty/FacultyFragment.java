package com.example.appdroid.ui.faculty;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.appdroid.R;


public class FacultyFragment extends Fragment {

    CardView wa1,wa2,wa3,wa4,wa5,wa6,wa7,wa8,wa9,wa10,wa11,wA1,wA2,see1,see2,prin;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_faculty, container, false);


        wa1= (CardView) view.findViewById(R.id.wa1);
        wa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openWhatsapp("+919631082346");
                openGmail("admin@heritageit.edu");
            }
        });

        prin= (CardView) view.findViewById(R.id.prin);
        prin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openWhatsapp("+919631082346");
                openGmail("principal@heritageit.edu");
            }
        });

        wa2= (CardView) view.findViewById(R.id.wa2);
        wa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("amitava.bagchi@heritageit.edu");
            }
        });

        wa3= (CardView) view.findViewById(R.id.wa3);
        wa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("subhashis.majumder@heritageit.edu");
            }
        });

        wa4= (CardView) view.findViewById(R.id.wa4);
        wa4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("poulami.das@heritageit.edu");
            }
        });

        wa5= (CardView) view.findViewById(R.id.wa5);
        wa5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("prosenjit.gupta@heritageit.edu");
            }
        });

        wa6= (CardView) view.findViewById(R.id.wa6);
        wa6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("aniruddha.dasgupta@heritageit.edu");
            }
        });

        wa7= (CardView) view.findViewById(R.id.wa7);
        wa7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("kamal.poddar@heritageit.edu");
            }
        });

        wa8= (CardView) view.findViewById(R.id.wa8);
        wa8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("dinabandhu.bhandari@heritageit.edu");
            }
        });

        wa9= (CardView) view.findViewById(R.id.wa9);
        wa9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("mohuya.byabartta@heritageit.edu");
            }
        });

        wa10= (CardView) view.findViewById(R.id.wa10);
        wa10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("Arindam.Chatterjee@heritageit.edu");
            }
        });

        wa11= (CardView) view.findViewById(R.id.wa11);
        wa11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail("sujay.saha@heritageit.edu");
            }
        });

        wA1= (CardView) view.findViewById(R.id.wA1);
        wA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWAgrp("https://chat.whatsapp.com/GAJb5zOpDss3Q7arFHfOKN");
            }
        });
        wA2= (CardView) view.findViewById(R.id.wA2);
        wA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTLgrp("https://t.me/joinchat/M3dUQU3DWVvuCk8rdReIpg");
            }
        });

        see1= (CardView) view.findViewById(R.id.see1);
        see1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), see_all1.class);
                startActivity(intent);
            }
        });

        see2= (CardView) view.findViewById(R.id.see2);
        see2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), see_all2.class);
                startActivity(intent);
            }
        });


        return view;

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