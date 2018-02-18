package com.antoniomaina.moneycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class Main extends AppCompatActivity {
    Spinner sp_services, sp_transactions;
    EditText et_amount, et_fee, et_balance;
    Button btn_calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initialize();
    }

    private void initialize() {
        et_amount = findViewById(R.id.et_amount);
        et_fee = findViewById(R.id.et_fee);
        et_balance = findViewById(R.id.et_balance);

        sp_services = findViewById(R.id.sp_services);
        ArrayAdapter<CharSequence> services_adapter = ArrayAdapter.createFromResource(this, R.array.services_array, android.R.layout.simple_spinner_item);
        services_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_services.setAdapter(services_adapter);

        sp_transactions = findViewById(R.id.sp_transactions);
        ArrayAdapter<CharSequence> transactions_adapter = ArrayAdapter.createFromResource(this, R.array.mpesa_transactions, android.R.layout.simple_spinner_item);
        transactions_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_transactions.setAdapter(transactions_adapter);

        btn_calculate = findViewById(R.id.btn_calculate);
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateRates();
            }
        });

    }

    private void calculateRates() {
        Toast.makeText(this, "Yaay!", Toast.LENGTH_SHORT).show();
    }
}
