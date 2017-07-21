package com.example.kwakgee.jsonproject3.JSon_DataManager.Remote;

import com.example.kwakgee.jsonproject3.JSon_Constants.Constants;
import com.example.kwakgee.jsonproject3.JSon_DataManager.Data.FrameVO;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by kwakgee on 2017. 7. 21..
 */

public interface RetrofitService {

    @GET("/ordinary")
    Call<FrameVO> getJsonData();

    static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
