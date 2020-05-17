package com.tainguyen.uit.appmusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tainguyen.uit.appmusic.Model.Album;
import com.tainguyen.uit.appmusic.R;

import java.util.List;

public class TimKiemAlbumAdapter extends BaseAdapter {
    private List<Album> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public TimKiemAlbumAdapter(Context aContext,  List<Album> listData) {
        this.context = aContext;
        this.listData = listData;
        this.layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return this.listData.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        TimKiemAlbumAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = this.layoutInflater.inflate(R.layout.row_timkiemalbum, null);
            holder = new TimKiemAlbumAdapter.ViewHolder();
            holder.hinhNenAlbum = convertView.findViewById(R.id.imageView_tkab_hinhnenalbum);
            holder.tenAlbum = convertView.findViewById(R.id.textView_tkab_tenalbum);
            holder.tenCaSi = convertView.findViewById(R.id.textView_tkab_tencasi);
            holder.soBaihat = convertView.findViewById(R.id.textView_tkab_sobaihat);
            convertView.setTag(holder);
        } else {
            holder = (TimKiemAlbumAdapter.ViewHolder) convertView.getTag();
        }

        Album album = this.listData.get(position);
        holder.soBaihat.setText(album.getSoBaihat().toString());
        holder.tenAlbum.setText(album.getName());
        holder.tenCaSi.setText(album.getCaSi());
        //holder.hinhNenAlbum.setImageBitmap();

        return convertView;
    }

    public static class ViewHolder {
        TextView tenAlbum;
        TextView soBaihat;
        TextView tenCaSi;
        ImageView hinhNenAlbum;
    }
}
