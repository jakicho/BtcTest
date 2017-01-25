package com.tran.ledgertest.mainActivity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tran.ledgertest.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInputFragment(savedInstanceState);
    }

    private void setInputFragment(Bundle savedInstanceState) {

        if (savedInstanceState == null) {
            InputFragment mFrag = new InputFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.activity_main, mFrag, "input_frag").commit();
        }
    }
}
