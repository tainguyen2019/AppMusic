package com.tainguyen.uit.appmusic.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tainguyen.uit.appmusic.Adapter.TimKiemTheLoaiAdapter;
import com.tainguyen.uit.appmusic.Model.TimKiemTheLoai;
import com.tainguyen.uit.appmusic.R;

import java.util.ArrayList;

public class Fragment_TimKiem_TheLoai extends Fragment {
    private View view;
    private ArrayList<TimKiemTheLoai> dataArrayList = new ArrayList<>();
    private TimKiemTheLoaiAdapter adapter;

    public ArrayList<TimKiemTheLoai> getDataArrayList() {
        return dataArrayList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_timkiemtheloai, container, false);

        this.initializeList();
        this.UpdateFragment();

        return this.view;
    }

    public void initializeList() {
        GridView gridView = (GridView) this.view.findViewById(R.id.gridview_tktl_thumucs);

        this.adapter = new TimKiemTheLoaiAdapter(this.getContext(), this.dataArrayList);
        gridView.setAdapter(this.adapter);
    }

    public void updateTextViewNoData() {
        TextView textViewNoData = (TextView) this.view.findViewById(R.id.textView_tktl_nodata);
        if (this.dataArrayList.size() < 1) {
            textViewNoData.setVisibility(View.VISIBLE);
        }
        else {
            textViewNoData.setVisibility(View.GONE);
        }
    }

    public void UpdateFragment() {
        this.adapter.notifyDataSetChanged();
        this.updateTextViewNoData();
    }
}
