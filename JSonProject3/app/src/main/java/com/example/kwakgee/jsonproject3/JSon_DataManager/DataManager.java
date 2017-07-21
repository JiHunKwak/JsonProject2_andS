package com.example.kwakgee.jsonproject3.JSon_DataManager;

import android.util.Log;

import com.example.kwakgee.jsonproject3.JSon_DataManager.Data.AppList;
import com.example.kwakgee.jsonproject3.JSon_DataManager.Data.FrameVO;
import com.example.kwakgee.jsonproject3.JSon_DataManager.Remote.RetrofitService;
import com.example.kwakgee.jsonproject3.JSon_Object.ListObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kwakgee on 2017. 7. 21..
 */

public class DataManager {

    public List<ListObject> listArr;

    public String master;

    private FrameVO frameVOList;
    private List<AppList> appLists;

    public void loadData() {

        listArr = new ArrayList<ListObject>();

        RetrofitService retrofitService = RetrofitService.retrofit.create(RetrofitService.class);
        Call<FrameVO> call = retrofitService.getJsonData();
        call.enqueue(new Callback<FrameVO>() {
            @Override
            public void onResponse(Call<FrameVO> call, Response<FrameVO> response) {
                frameVOList = response.body();
                appLists = frameVOList.getAppList();

                for(int i=0; i<appLists.size(); i++){
                    String rank = appLists.get(i).getRank();
                    String Nm = appLists.get(i).getNm();
                    String url = appLists.get(i).getUrl();

                    listArr.add(new ListObject(rank, Nm, url));


                    Log.v("This!!", listArr.get(i).getSequence());

                }

            }

            @Override
            public void onFailure(Call<FrameVO> call, Throwable t) {

            }
        });

    }

}
