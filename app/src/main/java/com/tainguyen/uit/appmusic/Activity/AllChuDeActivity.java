package com.tainguyen.uit.appmusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.tainguyen.uit.appmusic.Adapter.AllChuDeAdapter;
import com.tainguyen.uit.appmusic.Adapter.SpacesItemDecoration;
import com.tainguyen.uit.appmusic.Model.ChuDe;
import com.tainguyen.uit.appmusic.R;
import com.tainguyen.uit.appmusic.Service.APIService;
import com.tainguyen.uit.appmusic.Service.IDataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllChuDeActivity extends AppCompatActivity {

    Toolbar toolbarAllChuDe;
    RecyclerView recyclerViewAllChuDe;

    ArrayList<ChuDe> chuDeArrayList;
    AllChuDeAdapter allChuDeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_chu_de);

        Init();
        getData();


    }

    private void getData() {
        IDataService dataService = APIService.getService();
        Call<List<ChuDe>> callback = dataService.getAllChuDe();

        callback.enqueue(new Callback<List<ChuDe>>() {
            @Override
            public void onResponse(Call<List<ChuDe>> call, Response<List<ChuDe>> response) {
                chuDeArrayList = (ArrayList<ChuDe>) response.body();
                allChuDeAdapter = new AllChuDeAdapter(AllChuDeActivity.this, chuDeArrayList);

                recyclerViewAllChuDe.setLayoutManager(new GridLayoutManager(AllChuDeActivity.this, 2));
                recyclerViewAllChuDe.setAdapter(allChuDeAdapter);

                int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
                recyclerViewAllChuDe.addItemDecoration(new SpacesItemDecoration(spacingInPixels));

            }

            @Override
            public void onFailure(Call<List<ChuDe>> call, Throwable t) {

            }
        });
    }

    private void Init() {
        toolbarAllChuDe = findViewById(R.id.toolBarAllChuDe);
        recyclerViewAllChuDe = findViewById(R.id.recyclerViewAllChuDe);
        toolbarAllChuDe.setTitleTextColor(getResources().getColor(R.color.mautim));

        setSupportActionBar(toolbarAllChuDe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất cả chủ đề");

        toolbarAllChuDe.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
