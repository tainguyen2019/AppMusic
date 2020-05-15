package com.tainguyen.uit.appmusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;
import com.tainguyen.uit.appmusic.Activity.ListSongActivity;
import com.tainguyen.uit.appmusic.Model.QuangCao;
import com.tainguyen.uit.appmusic.R;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {

    Context context;
    ArrayList<QuangCao> arrayListbanner;

    public BannerAdapter(Context context, ArrayList<QuangCao> arrayListbanner) {
        this.context = context;
        this.arrayListbanner = arrayListbanner;
    }

    @Override
    public int getCount() {
        return arrayListbanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_banner, null);

        ImageView imageViewBackgroundBanner = view.findViewById(R.id.imageViewBackgroundBanner);
        ImageView imageViewSongBanner = view.findViewById(R.id.imageViewSongBanner);
        TextView textViewTitleSongBanner = view.findViewById(R.id.textViewTitleSongBanner);
        TextView textViewContentBanner = view.findViewById(R.id.textViewContenBanner);

        Picasso.with(context).load(arrayListbanner.get(position).getHinhAnh()).into(imageViewBackgroundBanner);
        Picasso.with(context).load(arrayListbanner.get(position).getHinhBaiHat()).into(imageViewSongBanner);
        textViewTitleSongBanner.setText(arrayListbanner.get(position).getTenBaiHat());
        textViewContentBanner.setText(arrayListbanner.get(position).getNoiDung());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ListSongActivity.class);
                intent.putExtra("banner", arrayListbanner.get(position));
                context.startActivity(intent);
            }
        });

        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
