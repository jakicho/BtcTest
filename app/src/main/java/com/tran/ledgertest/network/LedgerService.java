package com.tran.ledgertest.network;

import com.tran.ledgertest.models.JsonResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LedgerService {

    @GET("addresses/{address}/transactions?noToken=true")
    Call<JsonResult> getListTransactions(
            @Path("address") String address);

}
