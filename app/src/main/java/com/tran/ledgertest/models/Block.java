package com.tran.ledgertest.models;

/**
 * Created by Jacques on 25/01/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Block {

    @SerializedName("hash")
    @Expose
    private String hash;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("time")
    @Expose
    private String time;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
