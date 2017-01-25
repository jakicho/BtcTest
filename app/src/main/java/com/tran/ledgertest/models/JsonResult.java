package com.tran.ledgertest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class JsonResult {

    @SerializedName("txs")
    @Expose
    private ArrayList<Transaction> txs = new ArrayList<Transaction>();


    /**
     * @return The list of transactions
     */
    public List<Transaction> getTransactionsList() {
        return txs;
    }

}
