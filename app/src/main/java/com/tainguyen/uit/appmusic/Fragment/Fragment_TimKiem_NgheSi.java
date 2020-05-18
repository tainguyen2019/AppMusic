package com.tainguyen.uit.appmusic.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tainguyen.uit.appmusic.Adapter.TimKiemNgheSiAdapter;
import com.tainguyen.uit.appmusic.Model.TimKiemNgheSi;
import com.tainguyen.uit.appmusic.R;

import java.util.ArrayList;

public class Fragment_TimKiem_NgheSi extends Fragment {
    private View view;
    private ArrayList<TimKiemNgheSi> dataArrayList = new ArrayList<>();
    private TimKiemNgheSiAdapter adapter;

    public ArrayList<TimKiemNgheSi> getDataArrayList() {
        return dataArrayList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_timkiemnghesi, container, false);

        this.initializeList();
        this.UpdateFragment();

        return this.view;
    }

    public void initializeList() {
        ListView listView = (ListView) this.view.findViewById(R.id.listview_tkns_nghesi);

        this.adapter = new TimKiemNgheSiAdapter(this.getContext(), this.dataArrayList);
        listView.setAdapter(this.adapter);
    }

    public void UpdateFragment() {
        this.adapter.notifyDataSetChanged();
    }
}
