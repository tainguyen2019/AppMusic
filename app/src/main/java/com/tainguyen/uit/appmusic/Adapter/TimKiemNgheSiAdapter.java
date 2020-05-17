package com.tainguyen.uit.appmusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tainguyen.uit.appmusic.Model.NgheSi;
import com.tainguyen.uit.appmusic.R;

import java.util.List;

public class TimKiemNgheSiAdapter extends BaseAdapter {
    private List<NgheSi> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public TimKiemNgheSiAdapter(Context aContext,  List<NgheSi> listData) {
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
        TimKiemNgheSiAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = this.layoutInflater.inflate(R.layout.row_timkiemnghesi, null);
            holder = new TimKiemNgheSiAdapter.ViewHolder();
            holder.tenNgheSi = (TextView) convertView.findViewById(R.id.textview_tkns_tennghesi);
            holder.soTheLoai = (TextView) convertView.findViewById(R.id.textView_tkns_theloai);
            holder.soAlbum = (TextView) convertView.findViewById(R.id.textView_tkns_soalbum);
            holder.soLuotNghe = (TextView) convertView.findViewById(R.id.textView_tkns_luotnghe);
            holder.soBaiHat = (TextView) convertView.findViewById(R.id.textView_tkns_sobaihat);
            holder.hinhnen = (ImageView) convertView.findViewById(R.id.imageview_tkns_anhnghesi);
            holder.soChude = (TextView) convertView.findViewById(R.id.textView_tkns_chude);
            convertView.setTag(holder);
        } else {
            holder = (TimKiemNgheSiAdapter.ViewHolder) convertView.getTag();
        }

        NgheSi ngheSi = this.listData.get(position);
        holder.tenNgheSi.setText(ngheSi.getName());
        holder.soBaiHat.setText(ngheSi.getSoBaihat().toString());
        holder.soAlbum.setText(ngheSi.getSoAlbum().toString());
        holder.soLuotNghe.setText(ngheSi.getSoLuotnghe().toString());
        holder.soTheLoai.setText(ngheSi.getSoTheloai().toString());
        holder.soChude.setText(ngheSi.getSoChude().toString());
        //holder.hinhnen.setImageBitmap(///);

        return convertView;
    }

    public static class ViewHolder {
        TextView tenNgheSi;
        TextView soBaiHat;
        TextView soLuotNghe;
        TextView soAlbum;
        TextView soTheLoai;
        TextView soChude;
        ImageView hinhnen;
    }
}