package com.tainguyen.uit.appmusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tainguyen.uit.appmusic.Model.ChuDe;
import com.tainguyen.uit.appmusic.R;

import java.util.List;

public class TimKiemChuDeAdapter extends BaseAdapter {
    private List<ChuDe> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public TimKiemChuDeAdapter(Context aContext,  List<ChuDe> listData) {
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
        TimKiemChuDeAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = this.layoutInflater.inflate(R.layout.row_timkiemchude, null);
            holder = new TimKiemChuDeAdapter.ViewHolder();
            holder.tenChude = (TextView) convertView.findViewById(R.id.textView_tkcd_tenchude);
            holder.soBaiHat = (TextView) convertView.findViewById(R.id.textView_tkcd_sobaihat);
            holder.hinhnen = (ImageView) convertView.findViewById(R.id.imageView_tkcd_hinhnen);
            convertView.setTag(holder);
        } else {
            holder = (TimKiemChuDeAdapter.ViewHolder) convertView.getTag();
        }

        ChuDe chuDe = this.listData.get(position);
        holder.tenChude.setText(chuDe.getName());
        holder.soBaiHat.setText(chuDe.getSoBaiHat().toString());
        //holder.hinhnen.setImageBitmap(///);

        return convertView;
    }

    public static class ViewHolder {
        TextView soBaiHat;
        TextView tenChude;
        ImageView hinhnen;
    }
}
