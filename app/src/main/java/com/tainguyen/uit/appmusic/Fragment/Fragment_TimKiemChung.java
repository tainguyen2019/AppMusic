package com.tainguyen.uit.appmusic.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.tainguyen.uit.appmusic.Adapter.TimKiemChungAdapter;
import com.tainguyen.uit.appmusic.Adapter.TimKiemThuMucAdapter;
import com.tainguyen.uit.appmusic.Model.Album;
import com.tainguyen.uit.appmusic.Model.ChuDe;
import com.tainguyen.uit.appmusic.Model.NgheSi;
import com.tainguyen.uit.appmusic.Model.Playlist;
import com.tainguyen.uit.appmusic.Model.Song;
import com.tainguyen.uit.appmusic.Model.TheLoai;
import com.tainguyen.uit.appmusic.R;

import java.util.ArrayList;

public class Fragment_TimKiemChung extends Fragment {
    private View view;
    private ArrayList<Object> dataArrayList = new ArrayList<>();
    private TimKiemChungAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_timkiem_chung, container, false);

        this.initializeList();
        this.UpdateFragment();

        this.initializeEvents();

        return this.view;
    }

    public void initializeList() {
        ListView listView = (ListView) this.view.findViewById(R.id.listview_tkc_ketqua);

        //Tạo ra danh sách
        for (int i=0; i<100; i+=1) {
            if (i%2 == 0) {
                this.dataArrayList.add(new Song("" + i, "Song " + i, "", "", "", ""));
            }
            else if (i%3 == 0) {
                this.dataArrayList.add(new Album("" + i, "Album " + i, "", "", i));
            }
            else if (i%5 == 0) {
                this.dataArrayList.add(new ChuDe("" + i, "Chu de " + i, "", i));
            }
            else if (i%7 == 0) {
                this.dataArrayList.add(new NgheSi("" + i, "Nghe si " + i, i, i, i, i, i, ""));
            }
            else if (i%11 == 0) {
                this.dataArrayList.add(new Playlist("" + i, "Playlist " + i, ""));
            }
            else if (i%13 == 0) {
                this.dataArrayList.add(new TheLoai("" + i, "" + i, "The loai " + i, "", i));
            }
        }

        this.adapter = new TimKiemChungAdapter(this.getContext(), this.dataArrayList);
        listView.setAdapter(this.adapter);
    }

    public void UpdateFragment() {
        this.adapter.notifyDataSetChanged();
    }

    public void initializeKeywordAndButtonCancel() {
        final Button button_cancel = (Button) this.view.findViewById(R.id.button_tkc_cancel);
        final TextInputEditText edittext_keyword = (TextInputEditText) this.view.findViewById(R.id.edittext_tkc_keyword);

        //Khi nhập keyword
        edittext_keyword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //TODO
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //TODO
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() < 1) {
                    button_cancel.setVisibility(View.GONE);
                }
                else {
                    button_cancel.setVisibility(View.VISIBLE);
                }
            }
        });

        //Làm bàn phím ảo ẩn đi
        edittext_keyword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus == false) {
                    InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        });

        //Click nút cancel khi nhập keyword
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext_keyword.setText(null);
                edittext_keyword.clearFocus();
            }
        });
    }

    public void initializeEvents() {
        this.initializeKeywordAndButtonCancel();
    }
}
