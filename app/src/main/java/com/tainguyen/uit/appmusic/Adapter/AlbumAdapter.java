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
import com.tainguyen.uit.appmusic.Model.TimKiemAlbum;
import com.tainguyen.uit.appmusic.R;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    Context context;
    ArrayList<TimKiemAlbum> timKiemAlbumArrayList;

    public AlbumAdapter(Context context, ArrayList<TimKiemAlbum> timKiemAlbumArrayList) {
        this.context = context;
        this.timKiemAlbumArrayList = timKiemAlbumArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_album, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TimKiemAlbum timKiemAlbum = timKiemAlbumArrayList.get(position);
        holder.textViewTitleAlbum.setText(timKiemAlbum.getName());
        holder.textViewSinger.setText(timKiemAlbum.getCaSi());
        Picasso.with(context).load(timKiemAlbum.getHinhNen()).into(holder.imageViewAlbum);
    }

    @Override
    public int getItemCount() {
        return timKiemAlbumArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageViewAlbum;
        TextView textViewTitleAlbum, textViewSinger;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewAlbum = itemView.findViewById(R.id.imageViewAlbum);
            textViewSinger = itemView.findViewById(R.id.textViewSinger);
            textViewTitleAlbum = itemView.findViewById(R.id.textViewTitleAlbum);
        }
    }
}
