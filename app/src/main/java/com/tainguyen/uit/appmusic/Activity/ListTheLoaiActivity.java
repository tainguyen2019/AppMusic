package com.tainguyen.uit.appmusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tainguyen.uit.appmusic.Adapter.ListTheLoaiAdapter;
import com.tainguyen.uit.appmusic.Adapter.SpacesItemDecoration;
import com.tainguyen.uit.appmusic.Model.ChuDe;
import com.tainguyen.uit.appmusic.Model.TheLoai;
import com.tainguyen.uit.appmusic.R;
import com.tainguyen.uit.appmusic.Service.APIService;
import com.tainguyen.uit.appmusic.Service.IDataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListTheLoaiActivity extends AppCompatActivity {
    Toolbar toolbarListTheLoai;
    RecyclerView recyclerViewListTheLoai;

    ChuDe chuDe;
    ArrayList<TheLoai> theLoaiArrayList;
    ListTheLoaiAdapter listTheLoaiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_the_loai);

        getDataIntent();
        Init();
        getData();
    }

    private void getData() {
        IDataService dataService = APIService.getService();
        Call<List<TheLoai>> callback = dataService.getTheLoaiByChuDe(chuDe.getIDChuDe());

        callback.enqueue(new Callback<List<TheLoai>>() {
            @Override
            public void onResponse(Call<List<TheLoai>> call, Response<List<TheLoai>> response) {
                theLoaiArrayList = (ArrayList<TheLoai>) response.body();

                listTheLoaiAdapter = new ListTheLoaiAdapter(ListTheLoaiActivity.this, theLoaiArrayList);
                recyclerViewListTheLoai.setLayoutManager(new GridLayoutManager(ListTheLoaiActivity.this, 2));
                recyclerViewListTheLoai.setAdapter(listTheLoaiAdapter);

                int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
                recyclerViewListTheLoai.addItemDecoration(new SpacesItemDecoration(spacingInPixels));

            }

            @Override
            public void onFailure(Call<List<TheLoai>> call, Throwable t) {

            }
        });
    }

    private void Init() {
        recyclerViewListTheLoai = findViewById(R.id.recyclerViewListTheLoai);
        toolbarListTheLoai = findViewById(R.id.toolBarListTheLoai);

        setSupportActionBar(toolbarListTheLoai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(chuDe.getTenChuDe());
        toolbarListTheLoai.setTitleTextColor(getResources().getColor(R.color.mautim));

        toolbarListTheLoai.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getDataIntent() {
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("item_chude")){
                chuDe = (ChuDe) intent.getSerializableExtra("item_chude");
            }
        }
    }
}
