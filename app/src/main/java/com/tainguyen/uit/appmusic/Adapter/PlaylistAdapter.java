package com.tainguyen.uit.appmusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;
import com.tainguyen.uit.appmusic.Model.Playlist;
import com.tainguyen.uit.appmusic.R;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {
    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {
        super(context, resource, objects);
    }

    class ViewHolder{
        TextView textViewTenPlaylist;
        ImageView imageViewBackgroundPlaylist, imageViewPlaylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_playlist, null);
            viewHolder = new ViewHolder();
            viewHolder.textViewTenPlaylist = convertView.findViewById(R.id.textViewTenPlaylist);
            viewHolder.imageViewBackgroundPlaylist = convertView.findViewById(R.id.imageViewBackgroundPlaylist);
            viewHolder.imageViewPlaylist = convertView.findViewById(R.id.imageViewPlaylist);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Playlist playlist = getItem(position);
        Picasso.with(getContext()).load(playlist.getHinhNen()).into(viewHolder.imageViewBackgroundPlaylist);
        Picasso.with(getContext()).load(playlist.getHinhNen()).into(viewHolder.imageViewPlaylist);
        viewHolder.textViewTenPlaylist.setText(playlist.getTenPlaylist());


        return convertView;
    }
}
