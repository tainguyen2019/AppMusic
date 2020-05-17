package com.tainguyen.uit.appmusic.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.tainguyen.uit.appmusic.Adapter.TimkiemViewPagerAdapter;
import com.tainguyen.uit.appmusic.R;

public class Fragment_TimKiem extends Fragment {
    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private Fragment_TimKiem_BaiHat fragment_timKiem_baiHat;
    private Fragment_TimKiem_NgheSi fragment_timKiem_ngheSi;
    private Fragment_TimKiem_Album fragment_timKiem_album;
    private Fragment_TimKiem_ThuMuc fragment_timKiem_thuMuc;
    private Fragment_TimKiem_ChuDe fragment_timKiem_chuDe;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_timkiem, container, false);

        this.viewPager = (ViewPager) this.view.findViewById(R.id.timkiem_viewpager);
        this.tabLayout = (TabLayout) this.view.findViewById(R.id.filters);

        this.setupViewPager();
        this.tabLayout.setupWithViewPager(viewPager);

        this.initializeEvents();

        return view;
    }

    private void setupViewPager() {
        TimkiemViewPagerAdapter adapter = new TimkiemViewPagerAdapter(this.getFragmentManager());

        this.fragment_timKiem_baiHat = new Fragment_TimKiem_BaiHat();
        this.fragment_timKiem_album = new Fragment_TimKiem_Album();
        this.fragment_timKiem_ngheSi = new Fragment_TimKiem_NgheSi();
        this.fragment_timKiem_thuMuc = new Fragment_TimKiem_ThuMuc();
        this.fragment_timKiem_chuDe = new Fragment_TimKiem_ChuDe();

        adapter.addFragment(this.fragment_timKiem_baiHat, "Bài hát");
        adapter.addFragment(this.fragment_timKiem_ngheSi, "Nghệ sĩ");
        adapter.addFragment(this.fragment_timKiem_album, "Album");
        adapter.addFragment(this.fragment_timKiem_thuMuc, "Thể loại");
        adapter.addFragment(this.fragment_timKiem_chuDe, "Chủ đề");
        this.viewPager.setAdapter(adapter);
    }

    public void initializeEvents() {
    }



}
