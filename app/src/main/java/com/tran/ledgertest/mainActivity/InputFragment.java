package com.tran.ledgertest.mainActivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.tran.ledgertest.R;
import com.tran.ledgertest.resultsActivity.TransactionsActivity;
import com.tran.ledgertest.tools.Message;

import butterknife.Bind;
import butterknife.ButterKnife;


public class InputFragment extends Fragment {

    @Bind(R.id.et_address) public EditText et_address;
    @Bind(R.id.btn_input_address) public Button btn_input_address;
    @Bind(R.id.btn_default_address) public Button btn_default_address;

    public InputFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        ButterKnife.bind(this, view);
        setBtnClicks();
        return view;
    }

    private void setBtnClicks() {

        btn_default_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent checkIntent = new Intent(getContext(), TransactionsActivity.class);
                checkIntent.putExtra("address", getResources().getString(R.string.default_address));
                startActivity(checkIntent);
            }
        });

        btn_input_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputAddress = String.valueOf(et_address.getText());

                if(addressIsValid(inputAddress)) {

                    Intent checkIntent = new Intent(getContext(), TransactionsActivity.class);
                    checkIntent.putExtra("address", inputAddress);
                    startActivity(checkIntent);

                } else Message.message(getContext(), getResources().getString(R.string.invalid_address));

            }
        });
    }

    private boolean addressIsValid(String inputAddress) {

        return !(!inputAddress.startsWith("1") && !inputAddress.startsWith("3"))
                && !(inputAddress.length() != 26 && inputAddress.length() != 34);
    }
}
