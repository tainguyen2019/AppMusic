package com.tainguyen.uit.appmusic.Fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;
import com.tainguyen.uit.appmusic.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_Dia_Nhac extends Fragment {
    View view;
    CircleImageView circleImageView;
    ObjectAnimator objectAnimator;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.frament_dia_nhac,container,false);
        circleImageView=view.findViewById(R.id.imageviewcircle);
        objectAnimator=ObjectAnimator.ofFloat(circleImageView,"rotation",0f,360f);
        objectAnimator.setDuration(10000);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);
        objectAnimator.setInterpolator(new LinearInterpolator());
        return view;
    }
    public void Playnhac(String hinhanh) {
        Picasso.with(getActivity()).load(hinhanh).into(circleImageView);
        objectAnimator.start();
    }
    public void Pause()
    {
        objectAnimator.pause();
    }
}
