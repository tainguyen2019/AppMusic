package com.tainguyen.uit.appmusic.Service;

import com.tainguyen.uit.appmusic.Model.Song;
import com.tainguyen.uit.appmusic.Model.TimKiemAlbum;
import com.tainguyen.uit.appmusic.Model.TimKiemChuDe;
import com.tainguyen.uit.appmusic.Model.TimKiemPlaylist;
import com.tainguyen.uit.appmusic.Model.TimKiemTheLoai;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class TimKiemService {
    //Singleton
    private static TimKiemService instance = null;
    private TimKiemService(){
    }
    public static TimKiemService getInstance() {
        if (instance == null) {
            instance = new TimKiemService();
        }
        return instance;
    }

    //Properties
    private String BASE_URL = "http://10.0.2.2/Server/";

    public interface ITimKiemService {
        @GET("timkiem.php")
        Call<List<TimKiemAlbum>> getAlbumData(@Query("keyword") String keyword, @Query("type") String type);

        @GET("timkiem.php")
        Call<List<TimKiemChuDe>> getChuDeData(@Query("keyword") String keyword, @Query("type") String type);

        @GET("timkiem.php")
        Call<List<Song>> getSongData(@Query("keyword") String keyword, @Query("type") String type);

        @GET("timkiem.php")
        Call<List<TimKiemTheLoai>> getTheLoaiData(@Query("keyword") String keyword, @Query("type") String type);

        @GET("timkiem.php")
        Call<List<TimKiemPlaylist>> getPlaylistData(@Query("keyword") String keyword, @Query("type") String type);
    }

    //Menthods
    public ITimKiemService getService(){
        return APIRetrofitClient.getClient(BASE_URL).create(ITimKiemService.class);
    }

    public Call<List<TimKiemAlbum>> getTimkiemAlbumCallback(String keyword) {
        return this.getService().getAlbumData(keyword, "album");
    }

    public Call<List<TimKiemChuDe>> getTimKiemChuDeCallback(String keyword) {
        return this.getService().getChuDeData(keyword, "chude");
    }

    public Call<List<Song>> getTimKiemSongCallback(String keyword) {
        return this.getService().getSongData(keyword, "song");
    }

    public Call<List<TimKiemTheLoai>> getTimKiemTheLoaiCallback(String keyword) {
        return this.getService().getTheLoaiData(keyword, "theloai");
    }

    public Call<List<TimKiemPlaylist>> getTimKiemPlaylistCallback(String keyword) {
        return this.getService().getPlaylistData(keyword, "playlist");
    }
}
