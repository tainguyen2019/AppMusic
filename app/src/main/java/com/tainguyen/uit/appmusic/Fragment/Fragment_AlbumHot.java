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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tainguyen.uit.appmusic.Adapter.AlbumAdapter;
import com.tainguyen.uit.appmusic.Model.TimKiemAlbum;
import com.tainguyen.uit.appmusic.R;
import com.tainguyen.uit.appmusic.Service.APIService;
import com.tainguyen.uit.appmusic.Service.IDataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_AlbumHot extends Fragment {
    View view;
    RecyclerView recyclerViewAlbum;
    TextView textView_ViewMore;
    AlbumAdapter albumAdapter;
    ArrayList<TimKiemAlbum> timKiemAlbumArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_albumhot, container, false);
        recyclerViewAlbum = view.findViewById(R.id.recyclerViewAlbum);
        textView_ViewMore = view.findViewById(R.id.textView_ViewMore);
        getData();

        return view;
    }

    private void getData() {
        IDataService dataService = APIService.getService();
        Call<List<TimKiemAlbum>> callback = dataService.getAlbumToday();

        callback.enqueue(new Callback<List<TimKiemAlbum>>() {
            @Override
            public void onResponse(Call<List<TimKiemAlbum>> call, Response<List<TimKiemAlbum>> response) {
                timKiemAlbumArrayList = (ArrayList<TimKiemAlbum>) response.body();
                albumAdapter = new AlbumAdapter(getActivity(), timKiemAlbumArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewAlbum.setLayoutManager(linearLayoutManager);
                recyclerViewAlbum.setAdapter(albumAdapter);
            }

            @Override
            public void onFailure(Call<List<TimKiemAlbum>> call, Throwable t) {
                Log.d("BBB", t.getMessage());
            }
        });
    }
}
