package com.poli.gamereleases.adapter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.poli.gamereleases.R;

public class GameViewHolder extends RecyclerView.ViewHolder {

    TextView tvGameName;
    TextView tvReleaseDate;
    ImageView ivGameImage;


    public GameViewHolder(View gameView) {
        super(gameView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("GAME_CLICK", "View: " + view);
            }
        });

        tvGameName = itemView.findViewById(R.id.tvGameName);
        tvReleaseDate = itemView.findViewById(R.id.tvReleaseDate);
        ivGameImage = itemView.findViewById(R.id.ivGameImage);
    }
}
