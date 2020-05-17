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
import com.tainguyen.uit.appmusic.Adapter.TimKiemThuMucAdapter;
import com.tainguyen.uit.appmusic.Model.Song;
import com.tainguyen.uit.appmusic.Model.TheLoai;
import com.tainguyen.uit.appmusic.R;

import java.util.ArrayList;
import java.util.Random;

public class Fragment_TimKiem_ThuMuc extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_timkiemthumuc, container, false);

        this.UpdateFragment();

        return this.view;
    }

    public void UpdateFragment() {
        GridView gridView = (GridView) this.view.findViewById(R.id.gridview_tktm_thumucs);

        ArrayList<TheLoai> theLoaiArrayList = new ArrayList<>();

        //Tạo ra danh sách
        for (int i=0; i<100; i+=1) {
            theLoaiArrayList.add(new TheLoai(
                    "" + i,
                    "" + i,
                    "Thể loại " + i,
                    "",
                    new Random().nextInt(1000)
            ));
        }

        TimKiemThuMucAdapter timKiemThuMucAdapter = new TimKiemThuMucAdapter(this.getContext(), theLoaiArrayList);
        gridView.setAdapter(timKiemThuMucAdapter);

        timKiemThuMucAdapter.notifyDataSetChanged();
    }
}
