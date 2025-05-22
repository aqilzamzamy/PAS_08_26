package com.example.pas_08_26;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>{

    private Context context;
    private List<PlayerModel> teamList;

    public PlayerAdapter(Context context, List<PlayerModel> teamList) {
        this.context = context;
        this.teamList = teamList != null ? teamList : new ArrayList<>();
    }


    @NonNull
    @Override
    public PlayerAdapter.PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.team_menu, parent,false);
        return new PlayerAdapter.PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerAdapter.PlayerViewHolder holder, int position) {
        Model team= teamList.get(position);
        holder.tvNama.setText(team.getStrTeam());
        holder.tvNumber.setText(team.getStrStadium());
        holder.tvClub.setText(team.getStrStadium());

        Glide.with(context)
                .load(team.getStrBadge())
                .into(holder.ivImg);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PlayerViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvNumber, tvClub;
        ImageView ivImg;
        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama= itemView.findViewById(R.id.tvNama);
            tvNumber= itemView.findViewById(R.id.tvNumber);
            tvClub=itemView.findViewById(R.id.tvClub);
            ivImg=itemView.findViewById(R.id.ivImg);
        }
    }
}
