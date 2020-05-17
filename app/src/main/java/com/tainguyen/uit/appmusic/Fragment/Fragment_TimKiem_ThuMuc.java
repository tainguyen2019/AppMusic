package com.tainguyen.uit.appmusic.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tainguyen.uit.appmusic.Adapter.TimKiemBaiHatAdapter;
import com.tainguyen.uit.appmusic.Adapter.TimKiemNgheSiAdapter;
import com.tainguyen.uit.appmusic.Adapter.TimKiemThuMucAdapter;
import com.tainguyen.uit.appmusic.Model.NgheSi;
import com.tainguyen.uit.appmusic.Model.Song;
import com.tainguyen.uit.appmusic.Model.TheLoai;
import com.tainguyen.uit.appmusic.R;

import java.util.ArrayList;
import java.util.Random;

public class Fragment_TimKiem_ThuMuc extends Fragment {
    private View view;
    private ArrayList<TheLoai> dataArrayList = new ArrayList<>();
    private TimKiemThuMucAdapter adapter;

    public ArrayList<TheLoai> getDataArrayList() {
        return dataArrayList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_timkiemthumuc, container, false);

        this.initializeList();
        this.UpdateFragment();

        return this.view;
    }

    public void initializeList() {
        GridView gridView = (GridView) this.view.findViewById(R.id.gridview_tktm_thumucs);

        this.adapter = new TimKiemThuMucAdapter(this.getContext(), this.dataArrayList);
        gridView.setAdapter(this.adapter);
    }

    public void UpdateFragment() {
        this.adapter.notifyDataSetChanged();
    }
}
