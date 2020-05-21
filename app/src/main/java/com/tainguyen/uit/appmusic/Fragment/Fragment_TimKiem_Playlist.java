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

import com.tainguyen.uit.appmusic.Adapter.TimKiemPlaylistAdapter;
import com.tainguyen.uit.appmusic.Adapter.TimKiemTheLoaiAdapter;
import com.tainguyen.uit.appmusic.Model.TimKiemPlaylist;
import com.tainguyen.uit.appmusic.Model.TimKiemTheLoai;
import com.tainguyen.uit.appmusic.R;

import java.util.ArrayList;

public class Fragment_TimKiem_Playlist extends Fragment {
    private View view;
    private ArrayList<TimKiemPlaylist> dataArrayList = new ArrayList<>();
    private TimKiemPlaylistAdapter adapter;

    public ArrayList<TimKiemPlaylist> getDataArrayList() {
        return dataArrayList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_timkiemplaylist, container, false);

        GridView gridView = (GridView) this.view.findViewById(R.id.gridview_tkpl_playlist);
        this.adapter = new TimKiemPlaylistAdapter(this.getContext(), this.dataArrayList);
        gridView.setAdapter(this.adapter);

        this.UpdateFragment();

        return this.view;
    }

    public void updateTextViewNoData() {
        TextView textViewNoData = (TextView) this.view.findViewById(R.id.textView_tkpl_nodata);
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
