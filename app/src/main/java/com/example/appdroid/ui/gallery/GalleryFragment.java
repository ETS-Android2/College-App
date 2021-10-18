package com.example.appdroid.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdroid.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    RecyclerView cognitioRecView,urjaRecView,otherRecView;
    GalleryAdapter adapter;
    DatabaseReference ref;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        cognitioRecView= view.findViewById(R.id.cognitioRecView);
        urjaRecView= view.findViewById(R.id.urjaRecView);
        otherRecView= view.findViewById(R.id.otherRecView);

        ref= FirebaseDatabase.getInstance().getReference().child("gallery");

        getCognitioImage();

        getUrjaImage();

        getOtherImage();

        return view;
    }

    private void getCognitioImage() {
        ref.child("Cognitio").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot Snapshot:snapshot.getChildren()){
                    String data=(String) Snapshot.getValue();
                    imageList.add(data);
                }
                adapter= new GalleryAdapter(getContext(), imageList);
                cognitioRecView.setLayoutManager(new GridLayoutManager(getContext(),5));
                cognitioRecView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getUrjaImage() {
        ref.child("URJA").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot Snapshot:snapshot.getChildren()){
                    String data=(String) Snapshot.getValue();
                    imageList.add(data);
                }
                adapter= new GalleryAdapter(getContext(), imageList);
                urjaRecView.setLayoutManager(new GridLayoutManager(getContext(),5));
                urjaRecView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getOtherImage() {
        ref.child("Other events").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot Snapshot:snapshot.getChildren()){
                    String data=(String) Snapshot.getValue();
                    imageList.add(data);
                }
                adapter= new GalleryAdapter(getContext(), imageList);
                otherRecView.setLayoutManager(new GridLayoutManager(getContext(),5));
                otherRecView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}