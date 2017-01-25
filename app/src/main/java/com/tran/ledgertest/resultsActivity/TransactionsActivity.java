package com.tran.ledgertest.resultsActivity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tran.ledgertest.R;

public class TransactionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
        getSupportActionBar().setSubtitle(getIntent().getStringExtra("address"));
        setMainFragment(savedInstanceState);

    }

    private void setMainFragment(Bundle savedInstanceState) {

        if (savedInstanceState == null) {
            TransactionsFragment mFrag = new TransactionsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("address", getIntent().getStringExtra("address"));
            mFrag.setArguments(bundle);

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.activity_transactions, mFrag, "results_frag").commit();
        }
    }
}
