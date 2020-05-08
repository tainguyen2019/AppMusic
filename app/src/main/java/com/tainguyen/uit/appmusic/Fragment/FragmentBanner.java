package com.tainguyen.uit.appmusic.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tainguyen.uit.appmusic.Model.QuangCao;
import com.tainguyen.uit.appmusic.R;
import com.tainguyen.uit.appmusic.Service.APIService;
import com.tainguyen.uit.appmusic.Service.IDataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentBanner extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner, container, false);
        getData();

        return view;
    }

    private void getData(){
        IDataService dataService = APIService.getService();
        Call<List<QuangCao>> callback = dataService.GetDataBanner();

        callback.enqueue(new Callback<List<QuangCao>>() {
            @Override
            public void onResponse(Call<List<QuangCao>> call, Response<List<QuangCao>> response) {
                ArrayList<QuangCao> banners = (ArrayList<QuangCao>) response.body();
                Log.d("BBB",banners.get(0).getTenBaiHat());

            }

            @Override
            public void onFailure(Call<List<QuangCao>> call, Throwable t) {
                Log.d("BBB", "Error");
            }
        });

    }

}
