package com.tainguyen.uit.appmusic.Fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;
import com.tainguyen.uit.appmusic.Model.ChuDe;
import com.tainguyen.uit.appmusic.Model.ChuDeTheLoai;
import com.tainguyen.uit.appmusic.Model.TheLoai;
import com.tainguyen.uit.appmusic.R;
import com.tainguyen.uit.appmusic.Service.APIService;
import com.tainguyen.uit.appmusic.Service.IDataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ChuDeTheLoai extends Fragment {
    View view;
    HorizontalScrollView horizontalScrollView;
    TextView textView_ViewMore;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chudetheloai, container, false);
        horizontalScrollView = view.findViewById(R.id.horizoltalScrollView);
        textView_ViewMore = view.findViewById(R.id.textView_ViewMore);

        getData();

        return view;
    }

    private void getData(){
        IDataService dataService = APIService.getService();
        Call<ChuDeTheLoai> callback = dataService.GetChuDeTheLoaiToday();

        callback.enqueue(new Callback<ChuDeTheLoai>() {
            @Override
            public void onResponse(Call<ChuDeTheLoai> call, Response<ChuDeTheLoai> response) {
                ChuDeTheLoai chuDeTheLoaiToday = response.body();
                final ArrayList<ChuDe> chuDeArrayList = new ArrayList<>();
                chuDeArrayList.addAll(chuDeTheLoaiToday.getChuDe());

                final ArrayList<TheLoai> theLoaiArrayList = new ArrayList<>();
                theLoaiArrayList.addAll(chuDeTheLoaiToday.getTheLoai());

                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(580, 250);
                layoutParams.setMargins(10, 20, 10, 30);

                for(int i = 0; i < chuDeArrayList.size(); i++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);

                    if(chuDeArrayList.get(i).getHinhNen() != null){
                        Picasso.with(getActivity()).load(chuDeArrayList.get(i).getHinhNen()).into(imageView);
                    }

                    TextView textViewTitle = new TextView(getActivity());
                    textViewTitle.setText(chuDeArrayList.get(i).getName());
                    textViewTitle.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                    textViewTitle.setTextSize(20);
                    textViewTitle.setTypeface(null, Typeface.BOLD);
                    textViewTitle.setTextColor(Color.WHITE);

                    cardView.setLayoutParams(layoutParams);
                    cardView.addView(imageView);
                    cardView.addView(textViewTitle);
                    linearLayout.addView(cardView);
                }

                for(int j = 0; j < theLoaiArrayList.size(); j++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);

                    if(chuDeArrayList.get(j).getHinhNen() != null){
                        Picasso.with(getActivity()).load(theLoaiArrayList.get(j).getHinhNen()).into(imageView);
                    }

                    TextView textViewTitle = new TextView(getActivity());
                    textViewTitle.setText(theLoaiArrayList.get(j).getName());
                    textViewTitle.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                    textViewTitle.setTextSize(20);
                    textViewTitle.setTypeface(null, Typeface.BOLD);
                    textViewTitle.setTextColor(Color.WHITE);

                    cardView.setLayoutParams(layoutParams);
                    cardView.addView(imageView);
                    cardView.addView(textViewTitle);
                    linearLayout.addView(cardView);
                }

                horizontalScrollView.addView(linearLayout);
            }

            @Override
            public void onFailure(Call<ChuDeTheLoai> call, Throwable t) {
                Log.d("BBB", t.getMessage());
            }
        });

    }

}
