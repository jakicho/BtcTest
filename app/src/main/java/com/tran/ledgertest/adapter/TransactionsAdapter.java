package com.tran.ledgertest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tran.ledgertest.R;
import com.tran.ledgertest.models.Input;
import com.tran.ledgertest.models.Output;
import com.tran.ledgertest.models.Transaction;

import java.util.Collections;
import java.util.List;


public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.ViewHolder>{

    private LayoutInflater inflater;
    private String userAddress;
    private List<Transaction> mDataset = Collections.emptyList();

    public TransactionsAdapter(Context context, List<Transaction> mDataset, String userAddress){

        inflater = LayoutInflater.from(context);
        this.userAddress = userAddress;
        this.mDataset = mDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = inflater.inflate(R.layout.item_recycler, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Transaction current= mDataset.get(position);

        for (Input input : current.getInputs()) {
            if((input.getAddress()).equals(userAddress)) {
                holder.tvValue.setText("+"+ input.getValue()/1000 + "mBTC");
                holder.tvDirection.setText(R.string.tv_received);
                return;
            }
        }

        for(Output output: current.getOutputs()) {
            if( (output.getAddress()).equals(userAddress)) {
                holder.tvValue.setText("-"+ output.getValue()/1000 + "mBTC");
                holder.tvDirection.setText(R.string.tv_sent);
                return;
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvDirection;
        TextView tvValue;

        ViewHolder(View itemView) {

            super(itemView);

            tvDirection = (TextView) itemView.findViewById(R.id.tv_direction);
            tvValue = (TextView) itemView.findViewById(R.id.tv_amount);
        }
    }

    public void setDataset(List<Transaction> mDataset) {
        this.mDataset = mDataset;
    }

}