package com.example.userapplication.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    RecyclerView convoRecycler, independentRecycler, otherEventRecycler;
    GalleryAdapter adapter;
    DatabaseReference reference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        convoRecycler = view.findViewById(R.id.convoRecycler);
        independentRecycler = view.findViewById(R.id.independentRecycler);
        otherEventRecycler = view.findViewById(R.id.otherEventRecycler);
        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getConvoImage();
        getIndependentImage();
        getOtherImage();
        return view;
    }

    private void getOtherImage() {
        reference.child("Others Event").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String data = null;
                    try {
                        data = (String) snapshot.getValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    imageList.add(data);

                }
                adapter = new GalleryAdapter(getContext(), imageList);
                otherEventRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                otherEventRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getIndependentImage() {
        reference.child("Independence Day").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String data = (String) snapshot.getValue();
                    imageList.add(data);

                }
                adapter = new GalleryAdapter(getContext(), imageList);
                independentRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                independentRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getConvoImage() {
        reference.child("Convocation").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String data = (String) snapshot.getValue();
                    imageList.add(data);

                }
                adapter = new GalleryAdapter(getContext(), imageList);
                convoRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                convoRecycler.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}