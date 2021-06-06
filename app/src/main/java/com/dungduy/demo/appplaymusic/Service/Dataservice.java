package com.dungduy.demo.appplaymusic.Service;

import com.dungduy.demo.appplaymusic.Model.Quangcao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {

    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();
}
