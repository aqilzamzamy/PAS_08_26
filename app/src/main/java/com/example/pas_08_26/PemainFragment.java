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
    PlayerAdapter playerAdapter;
    List<PlayerModel> playerList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pemain, container, false);
        recyclerView= view.findViewById(R.id.rvPemain);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        playerList = new ArrayList<>();
        playerAdapter = new PlayerAdapter(getContext(), playerList);
        recyclerView.setAdapter(playerAdapter);


        loadTeamsFromApi();
        return view;
    }

    private void loadTeamsFromApi() {
        SportApi api = ApiClient.getClient().create(SportApi.class);
        Call<PlayerResponse> call = api.getPlayer("English Premier League");

        call.enqueue(new Callback<PlayerResponse>() {
            @Override
            public void onResponse(Call<PlayerResponse> call, Response<PlayerResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    playerList.clear();
                    playerList.addAll(response.body().getPlayer());
                    playerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<PlayerResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });
    }
}
