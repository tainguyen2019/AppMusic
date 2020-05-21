package com.tainguyen.uit.appmusic.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tainguyen.uit.appmusic.Adapter.HotSongAdapter;
import com.tainguyen.uit.appmusic.Model.Song;
import com.tainguyen.uit.appmusic.R;
import com.tainguyen.uit.appmusic.Service.APIService;
import com.tainguyen.uit.appmusic.Service.IDataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_HotSong extends Fragment {
    View view;
    RecyclerView recyclerViewHotSong;
    HotSongAdapter hotSongAdapter;
    ArrayList<Song> songArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_hotsong, container, false);
        recyclerViewHotSong = view.findViewById(R.id.recyclerViewHotSong);
        getData();

        return view;
    }

    private void getData() {
        IDataService dataService = APIService.getService();
        Call<List<Song>> callback = dataService.getHotSongs();

        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                songArrayList = (ArrayList<Song>) response.body();
                hotSongAdapter = new HotSongAdapter(getActivity(), songArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewHotSong.setLayoutManager(linearLayoutManager);
                recyclerViewHotSong.setAdapter(hotSongAdapter);

            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {
                Log.d("BBB", t.getMessage());
            }
        });
    }
}
