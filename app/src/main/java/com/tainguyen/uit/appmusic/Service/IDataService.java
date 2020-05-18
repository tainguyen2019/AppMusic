package com.tainguyen.uit.appmusic.Service;

import com.tainguyen.uit.appmusic.Model.Playlist;
import com.tainguyen.uit.appmusic.Model.TimKiemAlbum;
import com.tainguyen.uit.appmusic.Model.ChuDeTheLoai;
import com.tainguyen.uit.appmusic.Model.QuangCao;
import com.tainguyen.uit.appmusic.Model.TimKiemSong;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IDataService {
    @GET("getQuangCao.php")
    Call<List<QuangCao>> GetDataBanner();

    @GET("getPlaylistToday.php")
    Call<List<Playlist>> GetPlaylistToday();

    @GET("getChuDeTheLoaiToday.php")
    Call<ChuDeTheLoai> GetChuDeTheLoaiToday();

    @GET("getAlbumToday.php")
    Call<List<TimKiemAlbum>> getAlbumToday();

    @GET("getHotSongs.php")
    Call<List<TimKiemSong>> getHotSongs();
}
