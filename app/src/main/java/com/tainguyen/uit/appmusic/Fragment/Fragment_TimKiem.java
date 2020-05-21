package com.tainguyen.uit.appmusic.Fragment;


import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.tainguyen.uit.appmusic.Adapter.TimkiemViewPagerAdapter;
import com.tainguyen.uit.appmusic.Model.Song;
import com.tainguyen.uit.appmusic.Model.TimKiemAlbum;
import com.tainguyen.uit.appmusic.Model.TimKiemChuDe;
import com.tainguyen.uit.appmusic.Model.TimKiemPlaylist;
import com.tainguyen.uit.appmusic.Model.TimKiemTheLoai;
import com.tainguyen.uit.appmusic.R;
import com.tainguyen.uit.appmusic.Service.TimKiemService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_TimKiem extends Fragment {
    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private Fragment_TimKiem_BaiHat fragment_timKiem_baiHat;
    private Fragment_TimKiem_Album fragment_timKiem_album;
    private Fragment_TimKiem_TheLoai fragment_timKiem_theLoai;
    private Fragment_TimKiem_Playlist fragment_timKiem_playlist;
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

        this.tabLayout.getTabAt(0).select();
        this.searchAction(null);

        return view;
    }

    private void setupViewPager() {
        TimkiemViewPagerAdapter adapter = new TimkiemViewPagerAdapter(this.getFragmentManager());

        this.fragment_timKiem_baiHat = new Fragment_TimKiem_BaiHat();
        this.fragment_timKiem_album = new Fragment_TimKiem_Album();
        this.fragment_timKiem_theLoai = new Fragment_TimKiem_TheLoai();
        this.fragment_timKiem_playlist = new Fragment_TimKiem_Playlist();
        this.fragment_timKiem_chuDe = new Fragment_TimKiem_ChuDe();

        adapter.addFragment(this.fragment_timKiem_baiHat, "Bài hát");
        adapter.addFragment(this.fragment_timKiem_album, "Album");
        adapter.addFragment(this.fragment_timKiem_theLoai, "Thể loại");
        adapter.addFragment(this.fragment_timKiem_playlist, "Playlist");
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

        //Bắt sự kiện nhấn enter trong edittext_keyword
        edittext_keyword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    searchAction(null);

                    return true;
                }
                return false;
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
                searchAction(null);
                edittext_keyword.clearFocus();
            }
        });
    }

    public void initializeChangeTabEvent() {
        this.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                searchAction(tab.getPosition());
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

    //Tìm kiếm dựa trên tab và nội dung
    public void searchAction(Integer tabPosition) {
        final TextInputEditText edittext_keyword = (TextInputEditText) this.view.findViewById(R.id.edittext_tk_keyword);
        final String keyword = edittext_keyword.getText().toString();

        if (tabPosition == null) {
            tabPosition = this.tabLayout.getSelectedTabPosition();
        }

        if(!keyword.isEmpty()){
            switch (tabPosition) {
                case 0:
                    //BaiHat
                    SearchBaiHat(keyword);
                    break;
                case 1:
                    //Album
                    SearchAlbum(keyword);
                    break;
                case 2:
                    //The Loai
                    SearchTheLoai(keyword);
                    break;
                case 3:
                    //Playlist
                    SearchPlaylist(keyword);
                case 4:
                    //ChuDe
                    SearchChuDe(keyword);
                    break;
                default:
                    break;
            }
        }

        edittext_keyword.clearFocus();
    }

    public void SearchBaiHat(String keyword) {
        TimKiemService.getInstance().getTimKiemSongCallback(keyword).enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                ArrayList<Song> result = (ArrayList<Song>) response.body();

                if (fragment_timKiem_baiHat != null) {
                    fragment_timKiem_baiHat.getDataArrayList().clear();
                    fragment_timKiem_baiHat.getDataArrayList().addAll(result);
                    fragment_timKiem_baiHat.UpdateFragment();
                }
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {
                Toast.makeText(view.getContext(), "Lấy nội dung từ server lỗi", Toast.LENGTH_LONG);
            }
        });
    }

    public void SearchAlbum(String keyword) {
        TimKiemService.getInstance().getTimkiemAlbumCallback(keyword).enqueue(new Callback<List<TimKiemAlbum>>() {
            @Override
            public void onResponse(Call<List<TimKiemAlbum>> call, Response<List<TimKiemAlbum>> response) {
                ArrayList<TimKiemAlbum> result = (ArrayList<TimKiemAlbum>) response.body();

                if (fragment_timKiem_album != null) {
                    fragment_timKiem_album.getDataArrayList().clear();
                    fragment_timKiem_album.getDataArrayList().addAll(result);
                    fragment_timKiem_album.UpdateFragment();
                }
            }

            @Override
            public void onFailure(Call<List<TimKiemAlbum>> call, Throwable t) {
                Toast.makeText(view.getContext(), "Lấy nội dung từ server lỗi", Toast.LENGTH_LONG);
            }
        });
    }

    public void SearchTheLoai(String keyword) {
        TimKiemService.getInstance().getTimKiemTheLoaiCallback(keyword).enqueue(new Callback<List<TimKiemTheLoai>>() {
            @Override
            public void onResponse(Call<List<TimKiemTheLoai>> call, Response<List<TimKiemTheLoai>> response) {
                ArrayList<TimKiemTheLoai> result = (ArrayList<TimKiemTheLoai>) response.body();

                if (fragment_timKiem_theLoai != null) {
                    fragment_timKiem_theLoai.getDataArrayList().clear();
                    fragment_timKiem_theLoai.getDataArrayList().addAll(result);
                    fragment_timKiem_theLoai.UpdateFragment();
                }
            }

            @Override
            public void onFailure(Call<List<TimKiemTheLoai>> call, Throwable t) {
                Toast.makeText(view.getContext(), "Lấy nội dung từ server lỗi", Toast.LENGTH_LONG);
            }
        });
    }

    public void SearchPlaylist(String keyword) {
        TimKiemService.getInstance().getTimKiemPlaylistCallback(keyword).enqueue(new Callback<List<TimKiemPlaylist>>() {
            @Override
            public void onResponse(Call<List<TimKiemPlaylist>> call, Response<List<TimKiemPlaylist>> response) {
                ArrayList<TimKiemPlaylist> result = (ArrayList<TimKiemPlaylist>) response.body();

                if (fragment_timKiem_playlist != null) {
                    fragment_timKiem_playlist.getDataArrayList().clear();
                    fragment_timKiem_playlist.getDataArrayList().addAll(result);
                    fragment_timKiem_playlist.UpdateFragment();
                }

            }

            @Override
            public void onFailure(Call<List<TimKiemPlaylist>> call, Throwable t) {
                Toast.makeText(view.getContext(), "Lấy nội dung từ server lỗi", Toast.LENGTH_LONG);
            }
        });
    }

    public void SearchChuDe(String keyword) {
        TimKiemService.getInstance().getTimKiemChuDeCallback(keyword).enqueue(new Callback<List<TimKiemChuDe>>() {
            @Override
            public void onResponse(Call<List<TimKiemChuDe>> call, Response<List<TimKiemChuDe>> response) {
                ArrayList<TimKiemChuDe> result = (ArrayList<TimKiemChuDe>) response.body();

                if (fragment_timKiem_chuDe != null) {
                    fragment_timKiem_chuDe.getDataArrayList().clear();
                    fragment_timKiem_chuDe.getDataArrayList().addAll(result);
                    fragment_timKiem_chuDe.UpdateFragment();
                }
            }

            @Override
            public void onFailure(Call<List<TimKiemChuDe>> call, Throwable t) {
                Toast.makeText(view.getContext(), "Lấy nội dung từ server lỗi", Toast.LENGTH_LONG);
            }
        });
    }

    public void initializeEvents() {
        this.initializeKeywordAndButtonCancel();
        this.initializeChangeTabEvent();
    }
}
