package com.tainguyen.uit.appmusic.Service;

import com.tainguyen.uit.appmusic.Model.QuangCao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IDataService {
    @GET("getQuangCao.php")
    Call<List<QuangCao>> GetDataBanner();
}
