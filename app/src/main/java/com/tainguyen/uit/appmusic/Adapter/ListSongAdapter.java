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

import com.tainguyen.uit.appmusic.Activity.ListSongActivity;
import com.tainguyen.uit.appmusic.Activity.PlayNhacActivity;
import com.tainguyen.uit.appmusic.Model.Song;
import com.tainguyen.uit.appmusic.R;

import java.util.ArrayList;

public class ListSongAdapter extends RecyclerView.Adapter<ListSongAdapter.ViewHolder> {

    Context context;
    ArrayList<Song> songArrayList;

    public ListSongAdapter(Context context, ArrayList<Song> songArrayList) {
        this.context = context;
        this.songArrayList = songArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_listsong, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = songArrayList.get(position);
        holder.textViewSinger .setText(song.getCaSi());
        holder.textViewSong.setText(song.getTenBaiHat());
        holder.textViewIndexSong.setText(position + 1 + "");
        holder.textViewLuotNghe.setText(song.getLuotNghe() + " lượt nghe");

    }

    @Override
    public int getItemCount() {
        return songArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewIndexSong, textViewSong, textViewSinger, textViewLuotNghe;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewIndexSong = itemView.findViewById(R.id.textViewIndexSong);
            textViewSong = itemView.findViewById(R.id.textViewSong);
            textViewSinger = itemView.findViewById(R.id.textViewSinger);
            textViewLuotNghe = itemView.findViewById(R.id.textViewLuotNghe);

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
