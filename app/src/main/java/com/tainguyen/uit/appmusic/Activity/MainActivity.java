package com.tainguyen.uit.appmusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.tainguyen.uit.appmusic.Adapter.MainViewPagerAdapter;
import com.tainguyen.uit.appmusic.Fragment.Fragment_TimKiem;
import com.tainguyen.uit.appmusic.Fragment.Fragment_TimKiemChung;
import com.tainguyen.uit.appmusic.Fragment.Fragment_TrangChu;
import com.tainguyen.uit.appmusic.R;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Fragment_TimKiem fragment_timKiem;
    private Fragment_TimKiemChung fragment_timKiemChung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        Init();
    }

    private void Init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(this.getSupportFragmentManager());

        mainViewPagerAdapter.addFragment(new Fragment_TrangChu(), "\uD83C\uDFE0");

        this.fragment_timKiem = new Fragment_TimKiem();
        this.fragment_timKiem.setParentTabLayout(this.tabLayout);
        mainViewPagerAdapter.addFragment(this.fragment_timKiem, "☰");

        this.fragment_timKiemChung = new Fragment_TimKiemChung();
        this.fragment_timKiemChung.setParentTabLayout(this.tabLayout);
        mainViewPagerAdapter.addFragment(this.fragment_timKiemChung, "\uD83D\uDD0D");

        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 1) {
                    fragment_timKiem.updateTextButtonHome();
                }
                else if (tab.getPosition() == 2) {
                    fragment_timKiemChung.updateTextButtonBack();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //
            }
        });
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
