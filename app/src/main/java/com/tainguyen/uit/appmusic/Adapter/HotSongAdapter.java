package com.tainguyen.uit.appmusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tainguyen.uit.appmusic.Activity.PlayNhacActivity;
import com.tainguyen.uit.appmusic.Model.Song;
import com.tainguyen.uit.appmusic.R;

import java.util.ArrayList;

public class HotSongAdapter extends RecyclerView.Adapter<HotSongAdapter.ViewHolder> {
    Context context;
    ArrayList<Song> songArrayList;

    public HotSongAdapter(Context context, ArrayList<Song> songArrayList) {
        this.context = context;
        this.songArrayList = songArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_hotsong, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = songArrayList.get(position);
        holder.textViewHotSong.setText(song.getTenBaiHat());
        holder.textViewCaSi.setText(song.getCaSi());
        holder.textViewLuotNghe.setText(song.getLuotNghe() + " lượt nghe");
        Picasso.with(context).load(song.getHinhAnh()).into(holder.imageViewHotSong);

    }

    @Override
    public int getItemCount() {
        return songArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewHotSong, textViewCaSi, textViewLuotNghe;
        ImageView imageViewHotSong;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewHotSong = itemView.findViewById(R.id.textViewHotSong);
            textViewCaSi = itemView.findViewById(R.id.textViewCaSi);
            textViewLuotNghe = itemView.findViewById(R.id.textViewLuotNghe);
            imageViewHotSong = itemView.findViewById(R.id.imageViewHotSong);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("item_song", songArrayList.get(getPosition()));

                    context.startActivity(intent);
                }
            });
        }
    }
}
