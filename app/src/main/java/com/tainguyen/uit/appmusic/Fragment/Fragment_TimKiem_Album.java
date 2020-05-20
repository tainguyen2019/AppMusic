package com.tainguyen.uit.appmusic.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tainguyen.uit.appmusic.Activity.ListSongActivity;
import com.tainguyen.uit.appmusic.Adapter.TimKiemAlbumAdapter;
import com.tainguyen.uit.appmusic.Model.Album;
import com.tainguyen.uit.appmusic.Model.TimKiemAlbum;
import com.tainguyen.uit.appmusic.R;

import java.util.ArrayList;

public class Fragment_TimKiem_Album extends Fragment {
    private View view;
    private ArrayList<TimKiemAlbum> dataArrayList = new ArrayList<>();
    private TimKiemAlbumAdapter adapter;

    public ArrayList<TimKiemAlbum> getDataArrayList() {
        return dataArrayList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_timkiemalbum, container, false);

        this.initializeList();
        this.UpdateFragment();

        return this.view;
    }

    public void initializeList() {
        ListView listView = (ListView) this.view.findViewById(R.id.listview_tkab_albums);

       this.adapter = new TimKiemAlbumAdapter(this.getContext(), dataArrayList);
        listView.setAdapter(this.adapter);
    }

    public void updateTextViewNoData() {
        TextView textViewNoData = (TextView) this.view.findViewById(R.id.textView_tkab_nodata);
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
