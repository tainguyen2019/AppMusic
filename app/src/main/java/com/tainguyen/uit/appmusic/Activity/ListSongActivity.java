package com.tainguyen.uit.appmusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;
import com.tainguyen.uit.appmusic.Adapter.ListSongAdapter;
import com.tainguyen.uit.appmusic.Model.Album;
import com.tainguyen.uit.appmusic.Model.Playlist;
import com.tainguyen.uit.appmusic.Model.QuangCao;
import com.tainguyen.uit.appmusic.Model.Song;
import com.tainguyen.uit.appmusic.Model.TheLoai;
import com.tainguyen.uit.appmusic.R;
import com.tainguyen.uit.appmusic.Service.APIService;
import com.tainguyen.uit.appmusic.Service.IDataService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListSongActivity extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewListSong;
    FloatingActionButton floatingActionButton;
    ImageView imageViewListSong;

    Album album;
    QuangCao quangCao;
    Playlist playlist;
    TheLoai theLoai;
    ArrayList<Song> songArrayList;
    ListSongAdapter listSongAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_song);
        AnhXa();
        Init();
        getDataIntent();
        if(quangCao != null && quangCao.getIDBaiHat() != null){
            setValueInView(quangCao.getTenBaiHat(), quangCao.getHinhBaiHat());
            getDataQuangCao(quangCao.getIDBaiHat());
        }

        if(playlist != null && playlist.getIDPlaylist() != null){
            setValueInView(playlist.getTenPlaylist(), playlist.getHinhNen());
            getDataPlaylist(playlist.getIDPlaylist());
        }

        if(theLoai != null && theLoai.getIDTheLoai() != null){
            setValueInView(theLoai.getTenTheLoai(), theLoai.getHinhNen());
            getDataTheLoai(theLoai.getIDTheLoai());
        }

        if(album != null && album.getIDAlbum() != null){
            setValueInView(album.getTenAlbum(), album.getHinhNen());
            getDataAlbum(album.getIDAlbum());
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        startActivity(getIntent());
        finish();
    }

    private void getDataAlbum(String idAlbum) {
        IDataService dataService = APIService.getService();
        Call<List<Song>> callback = dataService.getListSongAlbum(idAlbum);

        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                songArrayList = (ArrayList<Song>) response.body();
                listSongAdapter = new ListSongAdapter(ListSongActivity.this, songArrayList);
                recyclerViewListSong.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
                recyclerViewListSong.setAdapter(listSongAdapter);

                handleEvenClick();
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }

    private void getDataTheLoai(String idTheLoai) {
        IDataService dataService = APIService.getService();
        Call<List<Song>> callback = dataService.getListSongTheLoai(idTheLoai);

        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                songArrayList = (ArrayList<Song>) response.body();
                listSongAdapter = new ListSongAdapter(ListSongActivity.this, songArrayList);
                recyclerViewListSong.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
                recyclerViewListSong.setAdapter(listSongAdapter);

                handleEvenClick();
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }

    private void getDataPlaylist(String idPlaylist) {
        IDataService dataService = APIService.getService();
        Call<List<Song>> callback = dataService.getListSongPlaylist(idPlaylist);

        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                songArrayList = (ArrayList<Song>) response.body();
                listSongAdapter = new ListSongAdapter(ListSongActivity.this, songArrayList);
                recyclerViewListSong.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
                recyclerViewListSong.setAdapter(listSongAdapter);

                handleEvenClick();
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }

    private void setValueInView(String name, String image) {
        collapsingToolbarLayout.setTitle(name);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        URL url = null;
        try {
            url = new URL(image);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            collapsingToolbarLayout.setBackground(bitmapDrawable);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Picasso.with(this).load(image).into(imageViewListSong);

    }

    private void getDataQuangCao(String IDBaiHat) {
        IDataService dataService = APIService.getService();
        Call<List<Song>> callback = dataService.getListSongBanner(IDBaiHat);
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                songArrayList = (ArrayList<Song>) response.body();
                listSongAdapter = new ListSongAdapter(ListSongActivity.this, songArrayList);
                recyclerViewListSong.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
                recyclerViewListSong.setAdapter(listSongAdapter);

                handleEvenClick();
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {
                Log.d("BBB", t.getMessage());
            }
        });
    }

    private void Init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);

        floatingActionButton.setEnabled(false);
    }

    private void AnhXa() {
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingToolbar);
        toolbar = findViewById(R.id.toolBarDanhSach);
        recyclerViewListSong = findViewById(R.id.recyclerViewListSong);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        imageViewListSong = findViewById(R.id.imageViewListSong);
    }

    private void getDataIntent() {
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("banner")){
                quangCao = (QuangCao) intent.getSerializableExtra("banner");
            }
            if(intent.hasExtra("item_playlist")){
                playlist = (Playlist) intent.getSerializableExtra("item_playlist");
            }
            if(intent.hasExtra("item_theloai")){
                theLoai = (TheLoai) intent.getSerializableExtra("item_theloai");
            }
            if(intent.hasExtra("item_album")){
                album = (Album) intent.getSerializableExtra("item_album");
            }
        }
    }

    private void handleEvenClick(){
        floatingActionButton.setEnabled(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListSongActivity.this, PlayNhacActivity.class);
                intent.putExtra("BaiHat", songArrayList);

                startActivity(intent);
            }
        });
    }
}
