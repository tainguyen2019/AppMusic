package com.tainguyen.uit.appmusic.Service;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;

import java.io.IOException;

public class PlayMp3 extends AsyncTask<String, Void, String> {
    public MediaPlayer mediaPlayer;
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
    }
}
