package com.tainguyen.uit.appmusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.tainguyen.uit.appmusic.Adapter.AllAlbumAdapter;
import com.tainguyen.uit.appmusic.Adapter.SpacesItemDecoration;
import com.tainguyen.uit.appmusic.Model.Album;
import com.tainguyen.uit.appmusic.R;
import com.tainguyen.uit.appmusic.Service.APIService;
import com.tainguyen.uit.appmusic.Service.IDataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllAlbumActivity extends AppCompatActivity {

    Toolbar toolbarAllAlbum;
    RecyclerView recyclerViewAllAlbum;

    ArrayList<Album> albumArrayList;
    AllAlbumAdapter allAlbumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_album);

        Init();
        getData();
    }

    private void getData() {
        IDataService dataService = APIService.getService();
        Call<List<Album>> callback = dataService.getAllAlbum();

        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                albumArrayList = (ArrayList<Album>) response.body();
                allAlbumAdapter = new AllAlbumAdapter(AllAlbumActivity.this, albumArrayList);

                recyclerViewAllAlbum.setLayoutManager(new GridLayoutManager(AllAlbumActivity.this, 2));
                recyclerViewAllAlbum.setAdapter(allAlbumAdapter);

                int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
                recyclerViewAllAlbum.addItemDecoration(new SpacesItemDecoration(spacingInPixels));

            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }

    private void Init() {
        toolbarAllAlbum = findViewById(R.id.toolBarAllAlbum);
        recyclerViewAllAlbum = findViewById(R.id.recyclerViewAllAlbum);

        setSupportActionBar(toolbarAllAlbum);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất cả album");
        toolbarAllAlbum.setTitleTextColor(getResources().getColor(R.color.mautim));

        toolbarAllAlbum.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
