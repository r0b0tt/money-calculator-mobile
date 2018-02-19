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

        sp_services.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).toString().equals("M-Pesa")) {
                    sp_transactions = findViewById(R.id.sp_transactions);
                    ArrayAdapter<CharSequence> transactions_adapter = ArrayAdapter.createFromResource(Main.this, R.array.mpesa_transactions, android.R.layout.simple_spinner_item);
                    transactions_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_transactions.setAdapter(transactions_adapter);
                } else if (parent.getItemAtPosition(position).toString().equals("Airtel Money")) {
                    sp_transactions = findViewById(R.id.sp_transactions);
                    ArrayAdapter<CharSequence> transactions_adapter = ArrayAdapter.createFromResource(Main.this, R.array.airtel_transactions, android.R.layout.simple_spinner_item);
                    transactions_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_transactions.setAdapter(transactions_adapter);
                } else {
                    sp_transactions = findViewById(R.id.sp_transactions);
                    ArrayAdapter<CharSequence> transactions_adapter = ArrayAdapter.createFromResource(Main.this, R.array.eazzy_transactions, android.R.layout.simple_spinner_item);
                    transactions_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_transactions.setAdapter(transactions_adapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Main.this, "Please select a service", Toast.LENGTH_SHORT).show();
            }
        });


        btn_calculate = findViewById(R.id.btn_calculate);
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateRates();
            }
        });

    }

    private void calculateRates() {
        // Get amount
        String amount = et_amount.getText().toString();

        if (amount.equals("")) {
            Toast.makeText(this, "Enter amount", Toast.LENGTH_SHORT).show();
        } else {
            // Get selected service
            String selected_service = sp_services.getSelectedItem().toString();

            switch (selected_service) {
                case "M-Pesa":
                    handleMpesa(Double.valueOf(amount));
                    break;

                case "Airtel Money":
                    handleAirtelMoney(Double.valueOf(amount));
                    break;

                case "Eazzy Pay":
                    handleEazzyPay(Double.valueOf(amount));
            }
        }

    }

    private void handleEazzyPay(Double amount) {
        /**
         * This function gets the rates for various transactions using Eazzy Banking.
         */
        String selected_transaction = sp_transactions.getSelectedItem().toString();
        Double fee = 0.00, balance = 0.00;
        KenyaTariffs kenyaTariffs = new KenyaTariffs();

        switch (selected_transaction) {
            case "Send to Equity Account":
                if (!kenyaTariffs.getTransferToEquityAccountMinMax(amount)) {
                    Toast.makeText(this, "Minimum and Maximum amounts are KShs. 1.00 and KShs. 300,000.00 respectively", Toast.LENGTH_SHORT).show();
                } else {
                    fee = kenyaTariffs.getTransferToEquityAccountRates();
                    balance = amount + fee;
                    et_fee.setText("KShs. " + fee);
                    et_balance.setText(("KShs. " + balance));
                }
                break;

            case "Agent Withdrawal":
                if (!kenyaTariffs.getAgentWithdrawalMinMax(amount)) {
                    Toast.makeText(this, "Minimum and Maximum amounts are KShs. 100.00 and KShs. 100,000.00 respectively", Toast.LENGTH_SHORT).show();
                } else {
                    fee = kenyaTariffs.getAgentWithdrawalRates(amount);
                    balance = fee + amount;
                }
                break;
            case "Send to Airtel Money/ M-PESA":
                if (!kenyaTariffs.getTransferToAirtelMpesaMinMax(amount)){
                    Toast.makeText(this, "Minimum and Maximum amounts are KShs. 100.00 and KShs. 35,000.00 respectively", Toast.LENGTH_SHORT).show();
                } else {
                    fee = kenyaTariffs.getTransferToAirtelMpesaRates();
                    balance = amount + fee;
                }
                break;
            case "Send to other Bank Account(PESA-LINK)":
                if (!kenyaTariffs.getTransferToOtherBankAccountPesaLinkMinMax(amount)){
                    Toast.makeText(this, "Minimum and Maximum amounts are KShs. 10.00 and KShs. 999,999.00 respectively", Toast.LENGTH_SHORT).show();
                } else {
                    fee = kenyaTariffs.getTransferToOtherBankAccountPesaLinkRates(amount);
                    balance = amount + fee;
                }
                break;
            case "Send to other Bank Account(RTGS)":
                if (!kenyaTariffs.getTransferToOtherBankAccountRtgsMinMax(amount)){
                    Toast.makeText(this, "Minimum and Maximum amounts are KShs. 1.00 and KShs. 100,000.00 respectively", Toast.LENGTH_SHORT).show();
                } else {
                    fee = kenyaTariffs.getTransferToOtherBankAccountRtgsRates();
                    balance = amount + fee;
                }
                break;
            case "Bill Payments":
                fee = kenyaTariffs.getBillPaymentsRates();
                balance = amount + fee;
                break;

        }

        if (fee == 0.00){
            et_fee.setText("N/A");
            et_balance.setText("N/A");
        } else {
            et_fee.setText("KShs. " + fee);
            et_balance.setText(("KShs. " + balance));
        }

    }

    private void handleAirtelMoney(Double amount) {
        /**
         * This function gets the rates for the various transactions using Airtel Money.
         */
        Toast.makeText(this, "Airtel", Toast.LENGTH_SHORT).show();
    }

    private void handleMpesa(Double amount) {
        /**
         * This function gets the rates for the various transactions using M-Pesa.
         */
        Toast.makeText(this, "Saf", Toast.LENGTH_SHORT).show();
    }
}
