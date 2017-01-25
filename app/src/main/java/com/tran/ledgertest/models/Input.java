package com.tran.ledgertest.models;

/**
 * Created by Jacques on 25/01/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Input {

    @SerializedName("input_index")
    @Expose
    private Integer inputIndex;
    @SerializedName("output_hash")
    @Expose
    private String outputHash;
    @SerializedName("output_index")
    @Expose
    private Integer outputIndex;
    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("script_signature")
    @Expose
    private String scriptSignature;

    public Integer getInputIndex() {
        return inputIndex;
    }

    public String getOutputHash() {
        return outputHash;
    }

    public Integer getOutputIndex() {
        return outputIndex;
    }

    public Integer getValue() {
        return value;
    }

    public String getAddress() {
        return address;
    }

    public String getScriptSignature() {
        return scriptSignature;
    }

}