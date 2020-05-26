package com.tainguyen.uit.appmusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tainguyen.uit.appmusic.Model.Song;
import com.tainguyen.uit.appmusic.R;

import java.util.ArrayList;

public class PlayNhacAdapter extends RecyclerView.Adapter<PlayNhacAdapter.ViewHolder>{
    Context context;
    ArrayList<Song> mangbaihat;

    public PlayNhacAdapter(Context context, ArrayList<Song> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.dong_play_bai_hat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Song song=mangbaihat.get(position);
        holder.txtcasi.setText(song.getCaSi());
        holder.txtindex.setText(position+1+"");
        holder.txttenbaihat.setText(song.getTenBaiHat());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("custom-message");
                intent.putExtra("position",position);
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder {
        TextView txtindex,txttenbaihat,txtcasi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtcasi=itemView.findViewById(R.id.textviewplaynhactencasi);
            txttenbaihat=itemView.findViewById(R.id.textviewplaytenbaihat);
            txtindex=itemView.findViewById(R.id.textviewplaynhacindex);
        }
    }
}
