package com.example.kwakgee.jsonproject3.JSon_DataManager.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kwakgee on 2017. 7. 21..
 */

public class AppList {

    @SerializedName("rank")
    @Expose
    private String rank;
    @SerializedName("Nm")
    @Expose
    private String nm;
    @SerializedName("url")
    @Expose
    private String url;

    public String getRank() {
        return rank;
    }

    public String getNm() {
        return nm;
    }

    public String getUrl() {
        return url;
    }
}
