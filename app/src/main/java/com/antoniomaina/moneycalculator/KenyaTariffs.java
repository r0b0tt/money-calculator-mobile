package com.antoniomaina.moneycalculator;

/**
 * Created by r0b0t on 2/19/18.
 */

public final class KenyaTariffs {
    public Boolean getTransferToAirtelMpesaMinMax(Double amount) {
        if (amount < 100.0 || amount > 35000.0)
            return false;
        else
            return true;
    }

    public Double getTransferToAirtelMpesaRates() {
        return 63.00;
    }

    public Boolean getTransferToOtherBankAccountPesaLinkMinMax(Double amount) {
        if (amount < 10.00 || amount > 999999.00)
            return false;
        else
            return true;
    }

    public Double getTransferToOtherBankAccountPesaLinkRates(Double amount) {
        if (amount < 500.00)
            return 0.00;
        else if (amount < 10000.00)
            return 37.00;
        else if (amount < 50000.00)
            return 62.00;
        else if (amount < 100000.00)
            return 87.00;
        else if (amount < 200000.00)
            return 112.00;
        else if (amount < 500000.00)
            return 137.00;
        else
            return 162.00;
    }

    public Boolean getTransferToOtherBankAccountRtgsMinMax(Double amount) {
        if (amount < 1.00 || amount > 100000.00)
            return false;
        else
            return true;
    }

    public Double getTransferToOtherBankAccountRtgsRates() {
        return 300.00;
    }

    public Boolean getTransferToEquityAccountMinMax(Double amount) {
        if (amount < 1.00 || amount > 300000.00)
            return false;
        else
            return true;
    }

    public Double getTransferToEquityAccountRates() {
        return 30.00;
    }

    public Boolean getAgentWithdrawalMinMax(Double amount) {
        if (amount < 100.00 || amount > 100000.00)
            return false;
        else
            return true;
    }

    public Double getAgentWithdrawalRates(Double amount) {
        if (amount < 2500.00 )
            return 27.50;
        else if (amount < 5000.00)
            return 37.50;
        else if (amount < 10000.00)
            return 82.50;
        else if (amount < 20000.00)
            return 159.50;
        else if (amount < 35000.00)
            return 187.00;
        else if (amount < 50000.00)
            return 214.50;
        else
            return 242.00;
    }

    public Double getBillPaymentsRates(){
        return 30.00;
    }

}
