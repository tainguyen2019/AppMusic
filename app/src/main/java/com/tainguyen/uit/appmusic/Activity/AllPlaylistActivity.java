package com.tainguyen.uit.appmusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tainguyen.uit.appmusic.Adapter.AllPlaylistAdapter;
import com.tainguyen.uit.appmusic.Adapter.SpacesItemDecoration;
import com.tainguyen.uit.appmusic.Model.Playlist;
import com.tainguyen.uit.appmusic.R;
import com.tainguyen.uit.appmusic.Service.APIService;
import com.tainguyen.uit.appmusic.Service.IDataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllPlaylistActivity extends AppCompatActivity {

    Toolbar toolbarAllPlaylist;
    RecyclerView recyclerViewAllPlaylist;

    AllPlaylistAdapter allPlaylistAdapter;
    ArrayList<Playlist> playlistArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_playlist);

        AnhXa();
        Init();
        getData();
    }

    private void getData() {
        IDataService dataService = APIService.getService();
        Call<List<Playlist>> callback = dataService.GetAllPlaylist();

        callback.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                playlistArrayList = (ArrayList<Playlist>) response.body();
                allPlaylistAdapter = new AllPlaylistAdapter(AllPlaylistActivity.this, playlistArrayList);
                recyclerViewAllPlaylist.setLayoutManager(new GridLayoutManager(AllPlaylistActivity.this, 2));
                recyclerViewAllPlaylist.setAdapter(allPlaylistAdapter);

                int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
                recyclerViewAllPlaylist.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        });
    }

    private void Init() {
        setSupportActionBar(toolbarAllPlaylist);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất cả playlist");
        toolbarAllPlaylist.setTitleTextColor(getResources().getColor(R.color.mautim));

        toolbarAllPlaylist.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void AnhXa() {
        toolbarAllPlaylist = findViewById(R.id.toolBarAllPlaylist);
        recyclerViewAllPlaylist = findViewById(R.id.recyclerViewAllPlaylist);
    }
}
