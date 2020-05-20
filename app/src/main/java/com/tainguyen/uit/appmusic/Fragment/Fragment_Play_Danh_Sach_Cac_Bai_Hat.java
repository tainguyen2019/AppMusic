package com.tainguyen.uit.appmusic.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tainguyen.uit.appmusic.Activity.MainActivity;
import com.tainguyen.uit.appmusic.Activity.PlayNhacActivity;
import com.tainguyen.uit.appmusic.Adapter.PlayNhacAdapter;
import com.tainguyen.uit.appmusic.R;

public class Fragment_Play_Danh_Sach_Cac_Bai_Hat extends Fragment {
    View view;
    RecyclerView recyclerViewplaynhac;
    PlayNhacAdapter playNhacAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_play_danh_sach_cac_bai_hat,container,false);
        recyclerViewplaynhac=view.findViewById(R.id.recyclerviewplaybaihat);
        if(PlayNhacActivity.ArrSong.size()>0)
        {
            playNhacAdapter=new PlayNhacAdapter(getActivity(), PlayNhacActivity.ArrSong);
            recyclerViewplaynhac.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerViewplaynhac.setAdapter(playNhacAdapter);
        }
        return view;
        }
}
