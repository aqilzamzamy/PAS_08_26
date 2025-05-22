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

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ModelViewHolder> {

    private Context context;
    private List<Model> teamList;

    public ModelAdapter(Context context, List<Model> teamList) {
        this.context = context;
        this.teamList = teamList != null ? teamList : new ArrayList<>();
    }


    @NonNull
    @Override
    public ModelAdapter.ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.team_menu, parent,false);
        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelAdapter.ModelViewHolder holder, int position) {
        Model team= teamList.get(position);
        holder.tvTeamName.setText(team.getStrTeam());
        holder.tvStadium.setText(team.getStrStadium());

        Glide.with(context)
                .load(team.getStrBadge())
                .into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public static class ModelViewHolder extends RecyclerView.ViewHolder {

        TextView tvTeamName, tvStadium;
        ImageView ivImage;
        public ModelViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTeamName= itemView.findViewById(R.id.tvTeamName);
            tvStadium= itemView.findViewById(R.id.tvStadium);
            ivImage=itemView.findViewById(R.id.ivImage);

        }
    }
}
