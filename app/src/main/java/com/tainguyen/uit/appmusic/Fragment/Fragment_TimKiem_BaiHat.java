package com.tainguyen.uit.appmusic.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tainguyen.uit.appmusic.Adapter.TimKiemAlbumAdapter;
import com.tainguyen.uit.appmusic.Adapter.TimKiemBaiHatAdapter;
import com.tainguyen.uit.appmusic.Model.Album;
import com.tainguyen.uit.appmusic.Model.Song;
import com.tainguyen.uit.appmusic.R;

import java.util.ArrayList;
import java.util.Random;

public class Fragment_TimKiem_BaiHat extends Fragment {
    private View view;
    private ArrayList<Song> dataArrayList = new ArrayList<>();
    private TimKiemBaiHatAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_timkiembaihat, container, false);

        this.initializeList();
        this.UpdateFragment();

        return this.view;
    }

    public void initializeList() {
        ListView listView = (ListView) this.view.findViewById(R.id.listview_tkbh_baihat);

        //Tạo ra danh sách
        for (int i=0; i<100; i+=1) {
            this.dataArrayList.add(new Song("" + i, "Bài hát " + i, "Ca siz " + i,
                    "", "", ""+new Random().nextInt(1000) +1));
        }

        this.adapter = new TimKiemBaiHatAdapter(this.getContext(), this.dataArrayList);
        listView.setAdapter(this.adapter);
    }

    public void UpdateFragment() {
        this.adapter.notifyDataSetChanged();
    }
}