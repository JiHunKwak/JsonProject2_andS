package com.example.kwakgee.jsonproject3.JSon_Object;

/**
 * Created by kwakgee on 2017. 7. 21..
 */

public class ListObject {

    private String rank;
    private String sequence;
    private String imgSrc;

    public ListObject(){

    }

    public ListObject(String rank, String sequence, String imgSrc) {
        this.rank = rank;
        this.sequence = sequence;
        this.imgSrc = imgSrc;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
