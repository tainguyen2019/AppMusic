package com.tainguyen.uit.appmusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tainguyen.uit.appmusic.Model.TheLoai;
import com.tainguyen.uit.appmusic.R;

import java.util.List;

public class TimKiemThuMucAdapter extends BaseAdapter {
    private List<TheLoai> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public TimKiemThuMucAdapter(Context aContext,  List<TheLoai> listData) {
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
        TimKiemThuMucAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = this.layoutInflater.inflate(R.layout.row_timkiemthumuc, null);
            holder = new TimKiemThuMucAdapter.ViewHolder();
            holder.tenTheloai = (TextView) convertView.findViewById(R.id.textView_tktm_tentheloai);
            holder.soBaiHat = (TextView) convertView.findViewById(R.id.textView_tktm_sobaihat);
            holder.tenChuDe = (TextView) convertView.findViewById(R.id.textView_tktm_tenchude);
            holder.hinhnen = (ImageView) convertView.findViewById(R.id.imageView_tktm_hinhnen);
            convertView.setTag(holder);
        } else {
            holder = (TimKiemThuMucAdapter.ViewHolder) convertView.getTag();
        }

        TheLoai theLoai = this.listData.get(position);
        holder.tenTheloai.setText(theLoai.getName());
        holder.soBaiHat.setText(theLoai.getSoBaiHat().toString());
        holder.tenChuDe.setText(theLoai.getIdChude());
        //holder.hinhnen.setImageBitmap(///);

        return convertView;
    }

    public static class ViewHolder {
        TextView tenTheloai;
        TextView soBaiHat;
        TextView tenChuDe;
        ImageView hinhnen;
    }
}
