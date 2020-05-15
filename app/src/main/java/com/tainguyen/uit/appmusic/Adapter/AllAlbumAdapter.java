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
import com.tainguyen.uit.appmusic.Activity.ListSongActivity;
import com.tainguyen.uit.appmusic.Model.Album;
import com.tainguyen.uit.appmusic.R;

import java.util.ArrayList;

public class AllAlbumAdapter extends RecyclerView.Adapter<AllAlbumAdapter.ViewHolder> {

    Context context;
    ArrayList<Album> albumArrayList;

    public AllAlbumAdapter(Context context, ArrayList<Album> albumArrayList) {
        this.context = context;
        this.albumArrayList = albumArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_allalbum, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = albumArrayList.get(position);

        Picasso.with(context).load(album.getHinhNen()).into(holder.imageViewAllAlbum);
        holder.textViewAllAlbum.setText(album.getTenAlbum());
        holder.textViewSingerAllAlbum.setText(album.getCaSi());

    }

    @Override
    public int getItemCount() {
        return albumArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewAllAlbum;
        TextView textViewAllAlbum, textViewSingerAllAlbum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewAllAlbum = itemView.findViewById(R.id.imageViewAllAlbum);
            textViewAllAlbum = itemView.findViewById(R.id.textViewAllAlbum);
            textViewSingerAllAlbum = itemView.findViewById(R.id.textViewSingerAllAlbum);

            imageViewAllAlbum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(context, ListSongActivity.class);
                    intent.putExtra("item_album", albumArrayList.get(getPosition()));

                    context.startActivity(intent);
                }
            });
        }
    }

}
