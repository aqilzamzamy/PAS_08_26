package com.example.pas_08_26;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PemainFragment extends Fragment {

    RecyclerView recyclerView;
    ModelAdapter teamAdapter;
    List<Model> teamList;
//    RecyclerView recyclerView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pemain, container, false);
        recyclerView= view.findViewById(R.id.rvPemain);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        teamList = new ArrayList<>();
        teamAdapter = new ModelAdapter(getContext(), teamList);
        recyclerView.setAdapter(teamAdapter);


        return view;
    }

    private void loadTeamsFromApi() {
        SportApi api = ApiClient.getClient().create(SportApi.class);
        Call<ModelResponse> call = api.getPlayers("English Premier League");

        call.enqueue(new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    teamList.clear();
                    teamList.addAll(response.body().getTeams());
                    teamAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
