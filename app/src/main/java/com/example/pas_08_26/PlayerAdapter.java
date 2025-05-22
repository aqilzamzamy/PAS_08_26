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

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerModelViewHolder> {
    private Context context;
    private List<PlayerModel> playerList;

    public PlayerAdapter(Context context, List<PlayerModel> playerList) {
        this.context = context;
        this.playerList = playerList != null ? playerList : new ArrayList<>();
    }

    @NonNull
    @Override
    public PlayerAdapter.PlayerModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.player_menu, parent,false);
        return new PlayerAdapter.PlayerModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerAdapter.PlayerModelViewHolder holder, int position) {
        PlayerModel team= playerList.get(position);
        holder.tvName.setText(team.getStrPlayer());
        holder.tvNumber.setText(team.getStrNumber());

        Glide.with(context)
                .load(team.getStrCutout())
                .into(holder.ivImg);
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    public class PlayerModelViewHolder extends RecyclerView.ViewHolder {

        TextView tvName,tvNumber;
       ImageView ivImg;
        public PlayerModelViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName= itemView.findViewById(R.id.tvName);
            tvNumber= itemView.findViewById(R.id.tvNumber);
            ivImg=itemView.findViewById(R.id.ivImg);

        }
    }
}
