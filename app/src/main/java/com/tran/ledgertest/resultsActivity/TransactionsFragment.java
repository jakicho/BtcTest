package com.tran.ledgertest.resultsActivity;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tran.ledgertest.R;
import com.tran.ledgertest.adapter.TransactionsAdapter;
import com.tran.ledgertest.models.Input;
import com.tran.ledgertest.models.JsonResult;
import com.tran.ledgertest.models.Output;
import com.tran.ledgertest.models.Transaction;
import com.tran.ledgertest.network.LedgerService;
import com.tran.ledgertest.tools.Message;

import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TransactionsFragment extends Fragment {

    @Bind(R.id.recycler_view) public RecyclerView recyclerView;
    @Bind(R.id.tv_balance) public TextView tvBalance;

    private String userAddress;
    private TransactionsAdapter mAdapter;
    private List<Transaction> mDataset;

    public TransactionsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_transactions, container, false);
        ButterKnife.bind(this, view);
        userAddress = getArguments().getString("address");
        setRecyclerView();
        getTransactionsData(getContext(), userAddress);

        return view;
    }


    public void getTransactionsData(final Context context, String addressToCheck) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.api_endpoint))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LedgerService ledgerService = retrofit.create(LedgerService.class);
        Call<JsonResult> call = ledgerService.getTransactionsList(addressToCheck);
        call.enqueue(new Callback<JsonResult>() {
            @Override
            public void onResponse(Call<JsonResult> call, Response<JsonResult> response) {

                Message.message(context, "Number of transactions: " + response.body().getTransactionsList().size());
                mDataset = response.body().getTransactionsList();
                tvBalance.setText("balance : " + getBalance(mDataset) + " sat");
                mAdapter.setDataset(response.body().getTransactionsList());
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<JsonResult> call, Throwable t) {

                Message.message(context, "ERROR\n" + t.getLocalizedMessage());
            }
        });
    }

    private void setRecyclerView() {

        if(mDataset == null) mDataset = Collections.emptyList();
        mAdapter = new TransactionsAdapter(getContext(), mDataset, userAddress);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(
                getContext(),1, GridLayoutManager.VERTICAL, false
        ));
    }


    // calcul le solde restant de l'adresse
    private int getBalance(List<Transaction> transactions) {

        int balance = 0;

        for (Transaction t: transactions) {

            boolean no_btc_received = true;

            for(Input i : t.getInputs()) {
                if((i.getAddress()).equals(userAddress)) {
                    balance += i.getValue();
                    no_btc_received = false;
                    break;
                }
            }

            if(no_btc_received) {
                for (Output o : t.getOutputs()) {
                    if((o.getAddress()).equals(userAddress)) {
                        balance -= o.getValue();
                        break;
                    }
                }
            }
        }

        return balance;
    }
}
