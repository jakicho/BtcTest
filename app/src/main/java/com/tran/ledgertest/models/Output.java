package com.tran.ledgertest.models;

/**
 * Created by Jacques on 25/01/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Output {

    @SerializedName("output_index")
    @Expose
    private Integer outputIndex;
    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("script_hex")
    @Expose
    private String scriptHex;

    public Integer getOutputIndex() {
        return outputIndex;
    }

    public Integer getValue() {
        return value;
    }

    public String getAddress() {
        return address;
    }

    public String getScriptHex() {
        return scriptHex;
    }

}
