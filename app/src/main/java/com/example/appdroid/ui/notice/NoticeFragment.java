package com.example.appdroid.ui.notice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdroid.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NoticeFragment extends Fragment {

    private RecyclerView noticeRecycler;
    private ProgressBar pb;
    private ArrayList<noticeData> list;
    private NoticeAdapter adapter;
    private DatabaseReference ref;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_notice, container, false);
        noticeRecycler=view. findViewById(R.id.noticeRecycler);
        pb= view.findViewById(R.id.pb);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Notice");


        noticeRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        noticeRecycler.setHasFixedSize(true);

        getNotice();
        return view;
    }

    private void getNotice() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Notice");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list= new ArrayList<>();
                for(DataSnapshot Snapshot : snapshot.getChildren()){
                    noticeData data= Snapshot.getValue(noticeData.class);
                    list.add(0,data);
                }

                adapter= new NoticeAdapter(getContext(),list);
                adapter.notifyDataSetChanged();
                pb.setVisibility(View.GONE);
                noticeRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}