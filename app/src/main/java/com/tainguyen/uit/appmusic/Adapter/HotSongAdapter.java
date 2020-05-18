package com.tainguyen.uit.appmusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tainguyen.uit.appmusic.Model.TimKiemSong;
import com.tainguyen.uit.appmusic.R;

import java.util.ArrayList;

public class HotSongAdapter extends RecyclerView.Adapter<HotSongAdapter.ViewHolder> {
    Context context;
    ArrayList<TimKiemSong> timKiemSongArrayList;

    public HotSongAdapter(Context context, ArrayList<TimKiemSong> timKiemSongArrayList) {
        this.context = context;
        this.timKiemSongArrayList = timKiemSongArrayList;
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
        TimKiemSong timKiemSong = timKiemSongArrayList.get(position);
        holder.textViewHotSong.setText(timKiemSong.getName());
        holder.textViewCaSi.setText(timKiemSong.getCaSi());
        holder.textViewLuotNghe.setText(timKiemSong.getLuotNghe() + " lượt nghe");
        Picasso.with(context).load(timKiemSong.getHinhAnh()).into(holder.imageViewHotSong);

    }

    @Override
    public int getItemCount() {
        return timKiemSongArrayList.size();
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
        }
    }
}
