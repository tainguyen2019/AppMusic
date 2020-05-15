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
import com.tainguyen.uit.appmusic.Activity.ListTheLoaiActivity;
import com.tainguyen.uit.appmusic.Model.ChuDe;
import com.tainguyen.uit.appmusic.R;

import java.util.ArrayList;

public class AllChuDeAdapter extends RecyclerView.Adapter<AllChuDeAdapter.ViewHolder> {

    Context context;
    ArrayList<ChuDe> chuDeArrayList;

    public AllChuDeAdapter(Context context, ArrayList<ChuDe> chuDeArrayList) {
        this.context = context;
        this.chuDeArrayList = chuDeArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_chude, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChuDe chuDe = chuDeArrayList.get(position);

        holder.textViewChuDe.setText(chuDe.getTenChuDe());
        Picasso.with(context).load(chuDe.getHinhNen()).into(holder.imageViewChuDe);
    }

    @Override
    public int getItemCount() {
        return chuDeArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewChuDe;
        ImageView imageViewChuDe;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewChuDe = itemView.findViewById(R.id.textViewChuDe);
            imageViewChuDe = itemView.findViewById(R.id.imageViewChuDe);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ListTheLoaiActivity.class);
                    intent.putExtra("item_chude", chuDeArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
