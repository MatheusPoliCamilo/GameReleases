package com.poli.gamereleases.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.poli.gamereleases.R;
import com.poli.gamereleases.model.Game;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class GameAdapter extends RecyclerView.Adapter<GameViewHolder>  {

    private Context context;
    private List<Game> data;
    private RequestOptions option;


    public GameAdapter(Context mContext, List<Game> mData) {
        this.context = mContext;
        this.data = mData;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);

    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.game_item, parent, false);

        return new com.poli.gamereleases.adapter.GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, int position) {

        holder.tvGameName.setText(data.get(position).getTitle());
        holder.tvReleaseDate.setText(data.get(position).getReleaseDate());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SS");
        dateFormat.setTimeZone(TimeZone.getDefault());

        SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date date = null;

        try {
            date = dateFormat.parse(data.get(position).getReleaseDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        holder.tvReleaseDate.setText(newFormat.format(date));

        Glide.with(context).load(data.get(position).getImageURL()).apply(option)
                .into(holder.ivGameImage);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
