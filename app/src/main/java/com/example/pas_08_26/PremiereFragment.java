package com.example.pas_08_26;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PremiereFragment extends Fragment {
    RecyclerView recyclerView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_premiere, container, false);
        recyclerView= view.findViewById(R.id.rvPremiere);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}
