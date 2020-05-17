package com.tainguyen.uit.appmusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tainguyen.uit.appmusic.Model.Album;
import com.tainguyen.uit.appmusic.Model.ChuDe;
import com.tainguyen.uit.appmusic.Model.NgheSi;
import com.tainguyen.uit.appmusic.Model.Playlist;
import com.tainguyen.uit.appmusic.Model.Song;
import com.tainguyen.uit.appmusic.Model.TheLoai;
import com.tainguyen.uit.appmusic.R;

import java.util.List;

public class TimKiemChungAdapter extends BaseAdapter {
    private List<Object> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public TimKiemChungAdapter(Context aContext,  List<Object> listData) {
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
        TimKiemChungAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = this.layoutInflater.inflate(R.layout.row_timkiemchung, null);
            holder = new TimKiemChungAdapter.ViewHolder();
            holder.ten = (TextView) convertView.findViewById(R.id.textView_tkc_name);
            holder.loai = (TextView) convertView.findViewById(R.id.textView_tkc_type);
            convertView.setTag(holder);
        } else {
            holder = (TimKiemChungAdapter.ViewHolder) convertView.getTag();
        }

        Object object = this.listData.get(position);

        Class objectClass = object.getClass();
        if (objectClass == Album.class) {
            Album objectAlbum = (Album) object;
            holder.ten.setText(objectAlbum.getName());
            holder.loai.setText("Album");
        }
        else if (objectClass == ChuDe.class) {
            ChuDe objectChuDe = (ChuDe) object;
            holder.ten.setText(objectChuDe.getName());
            holder.loai.setText("Chủ đề");
        }
        else if (objectClass == NgheSi.class) {
            NgheSi objectNgheSi = (NgheSi) object;
            holder.ten.setText(objectNgheSi.getName());
            holder.loai.setText("Nghệ sĩ");
        }
        else if (objectClass == Playlist.class) {
            Playlist objectPlaylist = (Playlist) object;
            holder.ten.setText(objectPlaylist.getName());
            holder.loai.setText("Danh sách phát");
        }
        else if (objectClass == Song.class) {
            Song objectSong = (Song) object;
            holder.ten.setText(objectSong.getName());
            holder.loai.setText("Bài hát");
        }
        else if (objectClass == TheLoai.class) {
            TheLoai objectTheLoai = (TheLoai) object;
            holder.ten.setText(objectTheLoai.getName());
            holder.loai.setText("Thể loại");
        }
        else {
            holder.ten.setText("Tên không xác định");
            holder.loai.setText("Loại không xác định");
        }

        holder.loai.setTag(object);

        return convertView;
    }

    public static class ViewHolder {
        TextView ten;
        TextView loai;
    }
}
