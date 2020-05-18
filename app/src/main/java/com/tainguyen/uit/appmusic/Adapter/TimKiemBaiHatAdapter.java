package com.tainguyen.uit.appmusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tainguyen.uit.appmusic.Model.TimKiemSong;
import com.tainguyen.uit.appmusic.R;

import java.util.List;

public class TimKiemBaiHatAdapter extends BaseAdapter {
    private List<TimKiemSong> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public TimKiemBaiHatAdapter(Context aContext,  List<TimKiemSong> listData) {
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
            convertView = this.layoutInflater.inflate(R.layout.row_timkiembaihat, null);
            holder = new ViewHolder();
            holder.tenBatHat = (TextView) convertView.findViewById(R.id.textview_tkbh_tenbaihat);
            holder.tenCaSi = (TextView) convertView.findViewById(R.id.textview_tkbh_nghesi);
            holder.luotNghe = (TextView) convertView.findViewById(R.id.textview_tkbh_luotnghe);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        TimKiemSong timKiemSong = this.listData.get(position);
        holder.tenBatHat.setText(timKiemSong.getName());
        holder.tenCaSi.setText(timKiemSong.getCaSi());
        holder.luotNghe.setText(timKiemSong.getLuotNghe().toString());

        return convertView;
    }

    public static class ViewHolder {
        TextView tenBatHat;
        TextView tenCaSi;
        TextView luotNghe;
    }
}
