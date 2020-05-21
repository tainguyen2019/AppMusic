package com.tainguyen.uit.appmusic.Service;

import com.tainguyen.uit.appmusic.Model.Album;
import com.tainguyen.uit.appmusic.Model.ChuDe;
import com.tainguyen.uit.appmusic.Model.ChuDeTheLoai;
import com.tainguyen.uit.appmusic.Model.Playlist;
import com.tainguyen.uit.appmusic.Model.QuangCao;
import com.tainguyen.uit.appmusic.Model.Song;
import com.tainguyen.uit.appmusic.Model.TheLoai;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IDataService {
    @GET("getQuangCao.php")
    Call<List<QuangCao>> GetDataBanner();

    @GET("getPlaylistToday.php")
    Call<List<Playlist>> GetPlaylistToday();

    @GET("getChuDeTheLoaiToday.php")
    Call<ChuDeTheLoai> GetChuDeTheLoaiToday();

    @GET("getAlbumToday.php")
    Call<List<Album>> getAlbumToday();

    @GET("getHotSongs.php")
    Call<List<Song>> getHotSongs();

    @FormUrlEncoded
    @POST("getListSong.php")
    Call<List<Song>> getListSongBanner(@Field("IDBaiHat") String IDBaiHat);

    @FormUrlEncoded
    @POST("getListSong.php")
    Call<List<Song>> getListSongPlaylist(@Field("IDPlaylist") String IDPlaylist);

    @GET("getAllPlaylist.php")
    Call<List<Playlist>> GetAllPlaylist();

    @FormUrlEncoded
    @POST("getListSong.php")
    Call<List<Song>> getListSongTheLoai(@Field("IDTheLoai") String IDTheLoai);

    @GET("getAllChuDe.php")
    Call<List<ChuDe>> getAllChuDe();

    @FormUrlEncoded
    @POST("getTheLoaiByChuDe.php")
    Call<List<TheLoai>> getTheLoaiByChuDe(@Field("IDChuDe") String IDChuDe);

    @FormUrlEncoded
    @POST("getListSong.php")
    Call<List<Song>> getListSongAlbum(@Field("IDAlbum") String IDAlbum);

    @GET("getAllAlbum.php")
    Call<List<Album>> getAllAlbum();

    @FormUrlEncoded
    @POST("updateLuotNghe.php")
    Call<Void> updateLuotNghe(@Field("idbaihat") String IDBaiHat);
}
