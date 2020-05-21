package com.tainguyen.uit.appmusic.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.tainguyen.uit.appmusic.Adapter.MainViewPagerAdapter;
import com.tainguyen.uit.appmusic.Fragment.Fragment_TimKiem;
import com.tainguyen.uit.appmusic.Fragment.Fragment_TrangChu;
import com.tainguyen.uit.appmusic.R;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        Init();

    }

    private void Init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_TrangChu(), "Trang chủ");
        mainViewPagerAdapter.addFragment(new Fragment_TimKiem(), "Tìm kiếm");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.icontimkiem);
    }


    private void AnhXa(){
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.myViewPager);
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


}
