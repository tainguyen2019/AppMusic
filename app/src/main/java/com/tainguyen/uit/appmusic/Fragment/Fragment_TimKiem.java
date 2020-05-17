package com.tainguyen.uit.appmusic.Fragment;


import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
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

    public void initializeKeywordAndButtonCancel() {
        final Button button_cancel = (Button) this.view.findViewById(R.id.button_tk_cancel);
        final TextInputEditText edittext_keyword = (TextInputEditText) this.view.findViewById(R.id.edittext_tk_keyword);

        //Khi nhập keyword
        edittext_keyword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //TODO
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //TODO
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() < 1) {
                    button_cancel.setVisibility(View.GONE);
                }
                else {
                    button_cancel.setVisibility(View.VISIBLE);
                }
            }
        });

        //Làm bàn phím ảo ẩn đi
        edittext_keyword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus == false) {
                    InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        });

        //Click nút cancel khi nhập keyword
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext_keyword.setText(null);
                edittext_keyword.clearFocus();
            }
        });
    }

    public void initializeEvents() {
        this.initializeKeywordAndButtonCancel();
    }
}
