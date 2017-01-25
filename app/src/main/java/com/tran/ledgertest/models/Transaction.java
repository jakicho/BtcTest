package com.tran.ledgertest.models;

/**
 * Created by Jacques on 25/01/2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transaction {

    @SerializedName("hash")
    @Expose
    private String hash;
    @SerializedName("received_at")
    @Expose
    private String receivedAt;
    @SerializedName("lock_time")
    @Expose
    private Integer lockTime;
    @SerializedName("block")
    @Expose
    private Block block;
    @SerializedName("inputs")
    @Expose
    private List<Input> inputs = null;
    @SerializedName("outputs")
    @Expose
    private List<Output> outputs = null;
    @SerializedName("fees")
    @Expose
    private Integer fees;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("confirmations")
    @Expose
    private Integer confirmations;

    public String getHash() {
        return hash;
    }

    public String getReceivedAt() {
        return receivedAt;
    }

    public Integer getLockTime() {
        return lockTime;
    }

    public Block getBlock() {
        return block;
    }

    public List<Input> getInputs() {
        return inputs;
    }

    public List<Output> getOutputs() {
        return outputs;
    }

    public Integer getFees() {
        return fees;
    }

    public void setFees(Integer fees) {
        this.fees = fees;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getConfirmations() {
        return confirmations;
    }

}
