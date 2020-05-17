package com.tainguyen.uit.appmusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.tainguyen.uit.appmusic.Adapter.MainViewPagerAdapter;
import com.tainguyen.uit.appmusic.Fragment.Fragment_TimKiem;
import com.tainguyen.uit.appmusic.Fragment.Fragment_TrangChu;
import com.tainguyen.uit.appmusic.R;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Fragment_TimKiem fragment_timKiem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        Init();
    }

    private void Init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(this.getSupportFragmentManager());

        mainViewPagerAdapter.addFragment(new Fragment_TrangChu(), "⛫");

        this.fragment_timKiem = new Fragment_TimKiem();
        mainViewPagerAdapter.addFragment(this.fragment_timKiem, "☰");

        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Bạn có chắc chắn muốn thoát ứng dụng không?")
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("Không", null)
                .show();
    }

    private void AnhXa(){
        tabLayout = this.findViewById(R.id.tabLayout);
        viewPager = this.findViewById(R.id.myViewPager);
    }
}
