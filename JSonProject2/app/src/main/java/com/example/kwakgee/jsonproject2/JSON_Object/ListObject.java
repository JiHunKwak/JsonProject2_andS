package com.example.kwakgee.jsonproject2.JSON_Object;

/**
 * Created by kwakgee on 2017. 7. 15..
 */

public class ListObject {

    private String rank;
    private String sequence;
    private String imageSrc;

    public ListObject(String rank, String sequence, String imageSrc) {
        this.rank = rank;
        this.sequence = sequence;
        this.imageSrc = imageSrc;
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

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    @Override
    public String toString() {
        return "ListObject{" +
                "rank='" + rank + '\'' +
                ", sequence='" + sequence + '\'' +
                ", imageSrc='" + imageSrc + '\'' +
                '}';
    }
}
