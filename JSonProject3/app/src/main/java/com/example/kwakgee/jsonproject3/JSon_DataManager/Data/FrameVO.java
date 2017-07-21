package com.example.kwakgee.jsonproject3.JSon_DataManager.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kwakgee on 2017. 7. 21..
 */

public class FrameVO {


    @SerializedName("master")
    @Expose
    private String master;
    @SerializedName("appList")
    @Expose
    private List<AppList> appList = null;

    public String getMaster() {
        return master;
    }

    public List<AppList> getAppList() {
        return appList;
    }
}
