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
import com.tainguyen.uit.appmusic.Model.Album;
import com.tainguyen.uit.appmusic.R;

import java.util.ArrayList;
import java.util.Random;

public class Fragment_TimKiem_Album extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_timkiemalbum, container, false);

        this.UpdateFragment();

        return this.view;
    }

    public void UpdateFragment() {
        ListView listView = (ListView) this.view.findViewById(R.id.listview_tkab_albums);

        ArrayList<Album> albumArrayList = new ArrayList<>();

        //Tạo ra danh sách
        for (int i=0; i<100; i+=1) {
            albumArrayList.add(new Album(
                ""+i,
                "Album " + i,
                "Ca sĩ " + i,
                "",
                new Random().nextInt(1000)
            ));
        }

        TimKiemAlbumAdapter timKiemAlbumAdapter = new TimKiemAlbumAdapter(this.getContext(), albumArrayList);
        listView.setAdapter(timKiemAlbumAdapter);

        timKiemAlbumAdapter.notifyDataSetChanged();
    }
}
