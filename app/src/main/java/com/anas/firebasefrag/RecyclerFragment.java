package com.anas.firebasefrag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class RecyclerFragment extends Fragment {

    public RecyclerFragment() {

    }


    RecyclerView vRV;
    Adapter_Student adapter_student;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);

        vRV=view.findViewById(R.id.vRV);
        vRV.setLayoutManager(new LinearLayoutManager(getActivity()));

        FirebaseRecyclerOptions<Model_Recycler> options =
                new FirebaseRecyclerOptions.Builder<Model_Recycler>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Students"), Model_Recycler.class)
                        .build();

        adapter_student = new Adapter_Student(options);
        vRV.setAdapter(adapter_student);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter_student.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter_student.stopListening();
    }
}