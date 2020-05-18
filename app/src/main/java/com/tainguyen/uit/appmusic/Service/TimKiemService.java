package com.tainguyen.uit.appmusic.Service;

import com.tainguyen.uit.appmusic.Model.TimKiemAlbum;

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
        Call<List<TimKiemAlbum>> getData(@Query("keyword") String keyword);
    }

    //Menthods
    public ITimKiemService getService(){
        return APIRetrofitClient.getClient(BASE_URL).create(ITimKiemService.class);
    }

    public Call<List<TimKiemAlbum>> getTimkiemAlbumCallback(String keyword) {
        return this.getService().getData(keyword);
    }
}
