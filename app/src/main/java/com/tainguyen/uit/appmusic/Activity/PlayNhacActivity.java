package com.tainguyen.uit.appmusic.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewpager.widget.ViewPager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tainguyen.uit.appmusic.Adapter.ViewPagePlayListNhac;
import com.tainguyen.uit.appmusic.Fragment.Fragment_Dia_Nhac;
import com.tainguyen.uit.appmusic.Fragment.Fragment_Play_Danh_Sach_Cac_Bai_Hat;
import com.tainguyen.uit.appmusic.Model.Song;
import com.tainguyen.uit.appmusic.R;
import com.tainguyen.uit.appmusic.Service.APIRetrofitClient;
import com.tainguyen.uit.appmusic.Service.APIService;
import com.tainguyen.uit.appmusic.Service.IDataService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayNhacActivity extends AppCompatActivity {
    Toolbar toolbarplaynhac;
    TextView txtTimesong, txtTotaltimesong;
    SeekBar sktime;
    ImageButton imgplay, imgrepeat, imgnext, imgpre, imgrandom, imageButtonTimer;
    ViewPager viewPagerplaynhac;
    public static ArrayList<Song> ArrSong = new ArrayList<>();
    public static ViewPagePlayListNhac adapternhac;
    Fragment_Dia_Nhac fragment_dia_nhac;
    Fragment_Play_Danh_Sach_Cac_Bai_Hat fragment_play_danh_sach_cac_bai_hat;
    MediaPlayer mediaPlayer;
    int position = 0;
    boolean repeat = false;
    boolean checkrandom = false;
    boolean next = false;
    boolean timer = false;
    int minutes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_nhac);
        toolbarplaynhac = findViewById(R.id.toolbarplaynhac);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        GetDataFromIntent();

        init();
        eventClick();

    }

    //lấy dữ liệu từ Intent
    private void GetDataFromIntent() {
        Intent intent = getIntent();
        ArrSong.clear();
        if (intent != null) {
            if (intent.hasExtra("BaiHat")) {
                ArrSong = intent.getParcelableArrayListExtra("BaiHat");
            }
            if (intent.hasExtra("item_song")) {
                ArrSong.add(intent.<Song>getParcelableExtra("item_song"));
            }
        }
    }

    private void init() {
        imgnext = findViewById(R.id.imagebuttonnext);
        toolbarplaynhac = findViewById(R.id.toolbarplaynhac);
        txtTimesong = findViewById(R.id.textviewtimesong);
        txtTotaltimesong = findViewById(R.id.textviewtotaltimesong);
        sktime = findViewById(R.id.seekbarsong);
        imgplay = findViewById(R.id.imagebuttonplay);
        imgrepeat = findViewById(R.id.imagebuttonrepeat);
        imgpre = findViewById(R.id.imagebuttonpreview);
        imgrandom = findViewById(R.id.imagebuttonsuffle);
        viewPagerplaynhac = findViewById(R.id.viewpagetplaynhac);
        imageButtonTimer = findViewById(R.id.imageButtonTimer);

        imageButtonTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater. from(PlayNhacActivity.this);
                View customDialogView = li.inflate(R.layout.custom_dialog, null);
                AlertDialog.Builder alertDialogBuilder = new
                        AlertDialog.Builder(PlayNhacActivity.this);
                alertDialogBuilder.setView(customDialogView);
                final EditText editTextTimer = (EditText) customDialogView.findViewById(R.id.editTextTimer);
                alertDialogBuilder.setCancelable(false).setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if( TextUtils.isEmpty(editTextTimer.getText())){
                                    editTextTimer.setError( "Vui lòng nhập số phút!" );
                                }else{
                                    minutes = Integer.valueOf(editTextTimer.getText().toString());
                                    timer = true;
                                    InitTimer(minutes);

                                }
                            }
                        })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        setSupportActionBar(toolbarplaynhac);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(ArrSong.get(position).getTenBaiHat());
        toolbarplaynhac.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                mediaPlayer.stop();
                ArrSong.clear();
            }
        });
        toolbarplaynhac.setTitleTextColor(Color.WHITE);

        fragment_dia_nhac = new Fragment_Dia_Nhac();
        fragment_play_danh_sach_cac_bai_hat = new Fragment_Play_Danh_Sach_Cac_Bai_Hat();
        adapternhac = new ViewPagePlayListNhac(getSupportFragmentManager());
        adapternhac.AddFragment(fragment_play_danh_sach_cac_bai_hat);
        adapternhac.AddFragment(fragment_dia_nhac);
        viewPagerplaynhac.setAdapter(adapternhac);
        fragment_dia_nhac = (Fragment_Dia_Nhac) adapternhac.getItem(1);
        if (ArrSong.size() > 0) {
            toolbarplaynhac.setTitle(ArrSong.get(0).getTenBaiHat());
            viewPagerplaynhac.setCurrentItem(1);
            new PlayMp3().execute(ArrSong.get(0).getLinkBaiHat());
            imgplay.setImageResource(R.drawable.iconpause);
        }
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("custom-message"));
    }

    private void InitTimer(final int time) {
        CountDownTimer countDownTimer = new CountDownTimer(time * 60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                mediaPlayer.pause();
                fragment_dia_nhac.Pause();
                imgplay.setImageResource(R.drawable.iconplay);
                timer = false;
                minutes = 0;
            }
        };

        countDownTimer.start();
    }

    public BroadcastReceiver mMessageReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            position=intent.getIntExtra("position",0);
            if(mediaPlayer.isPlaying()||mediaPlayer!=null)
            {
                mediaPlayer.stop();;
                mediaPlayer.release();
                mediaPlayer=null;
            }
            if(position<ArrSong.size())
            {
                imgplay.setImageResource(R.drawable.iconpause);
                new PlayMp3().execute(ArrSong.get(position).getLinkBaiHat());
                fragment_dia_nhac.Playnhac(ArrSong.get(position).getHinhAnh());
                toolbarplaynhac.setTitle(ArrSong.get(position).getTenBaiHat());
                Updatetime();
            }
        }
    };
    class PlayMp3 extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String baihat) {
            super.onPostExecute(baihat);
            try {

                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                    }
                });
                mediaPlayer.setDataSource(baihat);
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }

            mediaPlayer.start();
            updateLuotNghe(ArrSong.get(position).getIDBaiHat());
            TimeSong();
            Updatetime();
        }
    }

    private void updateLuotNghe(String idBaiHat) {
        IDataService dataService = APIService.getService();
        Call<Void> callback = dataService.updateLuotNghe(idBaiHat);

        try {
            callback.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void eventClick() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (adapternhac.getItem(1) != null) {
                    if (ArrSong.size() > 0) {
                        fragment_dia_nhac.Playnhac(ArrSong.get(0).getHinhAnh());
                        handler.removeCallbacks(this);
                    } else {
                        handler.postDelayed(this, 300);
                    }
                }
            }
        }, 500);
        imgplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    fragment_dia_nhac.Pause();
                    imgplay.setImageResource(R.drawable.iconplay);
                } else {
                    mediaPlayer.start();
                    fragment_dia_nhac.Playnhac(ArrSong.get(position).getHinhAnh());
                    imgplay.setImageResource(R.drawable.iconpause);
                }
            }
        });
        imgrepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (repeat == false) {
                    if (checkrandom == true) {
                        checkrandom = false;
                        imgrandom.setImageResource(R.drawable.iconsuffle);
                    }
                    imgrepeat.setImageResource(R.drawable.iconsyned);
                    repeat = true;
                } else {
                    imgrepeat.setImageResource(R.drawable.iconrepeat);
                    repeat = false;
                }
            }
        });
        imgrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkrandom == false) {
                    if (repeat == true) {
                        repeat = false;
                        imgrepeat.setImageResource(R.drawable.iconrepeat);
                    }
                    imgrandom.setImageResource(R.drawable.iconshuffled);
                    checkrandom = true;
                } else {
                    imgrandom.setImageResource(R.drawable.iconsuffle);
                    checkrandom = false;
                }
            }
        });
        sktime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ArrSong.size() > 0) {
                    if (mediaPlayer.isPlaying() || mediaPlayer != null) {
                        mediaPlayer.stop();
                        ;
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    if (position < ArrSong.size()) {
                        imgplay.setImageResource(R.drawable.iconpause);
                        position++;
                        if (repeat == true) {
                            if (position == 0) {
                                position = ArrSong.size();
                            }
                            position -= 1;
                        }
                        if (checkrandom == true) {
                            Random random = new Random();
                            int index = random.nextInt(ArrSong.size());
                            if (index == position) {
                                position = index - 1;
                            }
                            position = index;
                        }
                        if (position > (ArrSong.size() - 1)) {
                            position = 0;
                        }
                        Log.d("NNNN", "1" + ArrSong.get(0).getLinkBaiHat());
                        new PlayMp3().execute(ArrSong.get(position).getLinkBaiHat());
                        fragment_dia_nhac.Playnhac(ArrSong.get(position).getHinhAnh());
                        toolbarplaynhac.setTitle(ArrSong.get(position).getTenBaiHat());
                        Updatetime();
                    }
                }
                imgpre.setClickable(false);
                imgnext.setClickable(false);
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgpre.setClickable(true);
                        imgnext.setClickable(true);
                    }
                }, 1000);
            }
        });
        imgpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ArrSong.size() > 0) {
                    if (mediaPlayer.isPlaying() || mediaPlayer != null) {
                        mediaPlayer.stop();
                        ;
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    if (position < ArrSong.size()) {
                        imgplay.setImageResource(R.drawable.iconpause);
                        position--;
                        if (position < 0) {
                            position = ArrSong.size() - 1;
                        }
                        if (repeat == true) {
                            position += 1;
                        }
                        if (checkrandom == true) {
                            Random random = new Random();
                            int index = random.nextInt(ArrSong.size());
                            if (index == position) {
                                position = index - 1;
                            }
                            position = index;
                        }
                        Log.d("NNNN", "2" + ArrSong.get(0).getLinkBaiHat());
                        new PlayMp3().execute(ArrSong.get(position).getLinkBaiHat());
                        fragment_dia_nhac.Playnhac(ArrSong.get(position).getHinhAnh());
                        toolbarplaynhac.setTitle(ArrSong.get(position).getTenBaiHat());
                        Updatetime();
                    }
                }
                imgpre.setClickable(false);
                imgnext.setClickable(false);
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgpre.setClickable(true);
                        imgnext.setClickable(true);
                    }
                }, 1000);
            }
        });
    }


    private void TimeSong() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        int timesongtotal = mediaPlayer.getDuration();
        txtTotaltimesong.setText(simpleDateFormat.format(timesongtotal));
        sktime.setMax(timesongtotal);
    }

    private void Updatetime() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null) {
                    sktime.setProgress(mediaPlayer.getCurrentPosition());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                    txtTimesong.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
                    handler.postDelayed(this, 300);
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            next = true;
                        }
                    });
                }
            }
        }, 300);
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (next == true) {
                    if (ArrSong.size() > 0) {
                        if (position < ArrSong.size()) {
                            imgplay.setImageResource(R.drawable.iconpause);
                            position++;
                            if (repeat == true) {
                                if (position == 0) {
                                    position = ArrSong.size();
                                }
                                position -= 1;
                            }
                            if (checkrandom == true) {
                                Random random = new Random();
                                int index = random.nextInt(ArrSong.size());
                                if (index == position) {
                                    position = index - 1;
                                }
                                position = index;
                            }
                            if (position > (ArrSong.size() - 1)) {
                                position = 0;
                            }
                            new PlayMp3().execute(ArrSong.get(position).getLinkBaiHat());
                            fragment_dia_nhac.Playnhac(ArrSong.get(position).getHinhAnh());
                            toolbarplaynhac.setTitle(ArrSong.get(position).getTenBaiHat());
                        }
                    }
                    imgpre.setClickable(false);
                    imgnext.setClickable(false);
                    Handler handler1 = new Handler();
                    handler1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            imgpre.setClickable(true);
                            imgnext.setClickable(true);
                        }
                    }, 3000);
                    next = false;
                    handler1.removeCallbacks(this);
                } else {
                    handler1.postDelayed(this, 1000);
                }
            }
        }, 1000);
    }
}



