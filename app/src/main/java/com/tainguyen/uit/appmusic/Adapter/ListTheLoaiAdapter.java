package com.tainguyen.uit.appmusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tainguyen.uit.appmusic.Activity.ListSongActivity;
import com.tainguyen.uit.appmusic.Model.TheLoai;
import com.tainguyen.uit.appmusic.R;

import java.util.ArrayList;

public class ListTheLoaiAdapter extends RecyclerView.Adapter<ListTheLoaiAdapter.ViewHolder>  {

    Context context;
    ArrayList<TheLoai> theLoaiArrayList;

    public ListTheLoaiAdapter(Context context, ArrayList<TheLoai> theLoaiArrayList) {
        this.context = context;
        this.theLoaiArrayList = theLoaiArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_theloai, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TheLoai theLoai = theLoaiArrayList.get(position);

        holder.textViewTheLoai.setText(theLoai.getTenTheLoai());
        Picasso.with(context).load(theLoai.getHinhNen()).into(holder.imageViewTheLoai);
    }

    @Override
    public int getItemCount() {
        return theLoaiArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewTheLoai;
        TextView textViewTheLoai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewTheLoai = itemView.findViewById(R.id.imageViewTheLoai);
            textViewTheLoai = itemView.findViewById(R.id.textViewTheLoai);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ListSongActivity.class);
                    intent.putExtra("item_theloai", theLoaiArrayList.get(getPosition()) );
                    context.startActivity(intent);
                }
            });
        }
    }
}
