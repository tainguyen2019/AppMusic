package com.tainguyen.uit.appmusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tainguyen.uit.appmusic.Activity.ListSongActivity;
import com.tainguyen.uit.appmusic.Model.Album;
import com.tainguyen.uit.appmusic.Model.Playlist;
import com.tainguyen.uit.appmusic.Model.TimKiemPlaylist;
import com.tainguyen.uit.appmusic.Model.TimKiemTheLoai;
import com.tainguyen.uit.appmusic.R;

import java.util.List;

public class TimKiemPlaylistAdapter extends BaseAdapter {
    private List<TimKiemPlaylist> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public TimKiemPlaylistAdapter(Context aContext, List<TimKiemPlaylist> listData) {
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
        ViewHolder holder;
        if (convertView == null) {
            convertView = this.layoutInflater.inflate(R.layout.row_timkiemplaylist, null);
            holder = new ViewHolder();
            holder.tenPlaylist = (TextView) convertView.findViewById(R.id.textView_tktm_tenplaylist);
            holder.soBaiHat = (TextView) convertView.findViewById(R.id.textView_tktm_sobaihat);
            holder.hinhnen = (ImageView) convertView.findViewById(R.id.imageView_tktm_hinhnen);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final TimKiemPlaylist timKiemPlaylist = this.listData.get(position);
        holder.tenPlaylist.setText(timKiemPlaylist.getTenPlaylist());
        holder.soBaiHat.setText(timKiemPlaylist.getSobaihat() + " bài hát");
        Picasso.with(context).load(timKiemPlaylist.getHinhNen()).into(holder.hinhnen);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(context, ListSongActivity.class);
                intent.putExtra("item_playlist", new Playlist(timKiemPlaylist.getIDPlaylist(), timKiemPlaylist.getTenPlaylist()
                                                                    ,timKiemPlaylist.getHinhNen()));

                context.startActivity(intent);
            }
        });

        return convertView;
    }

    public static class ViewHolder {
        TextView tenPlaylist;
        TextView soBaiHat;
        ImageView hinhnen;
    }
}
