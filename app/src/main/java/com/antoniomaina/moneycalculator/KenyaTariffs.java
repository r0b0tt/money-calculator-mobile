package com.antoniomaina.moneycalculator;

/**
 * Created by r0b0t on 2/19/18.
 */

public final class KenyaTariffs {
    /*
    Eazzy Banking.
     */
    public Boolean getEazzyBankingTransferToAirtelMpesaMinMax(Double amount) {
        if (amount < 100.00 || amount > 35000.00)
            return false;
        else
            return true;
    }

    public Double getEazzyBankingTransferToAirtelMpesaRates() {
        return 63.00;
    }

    public Boolean getEazzyBankingTransferToOtherBankAccountPesaLinkMinMax(Double amount) {
        if (amount < 10.00 || amount > 999999.00)
            return false;
        else
            return true;
    }

    public Double getEazzyBankingTransferToOtherBankAccountPesaLinkRates(Double amount) {
        if (amount <= 500.00)
            return 0.00;
        else if (amount <= 10000.00)
            return 37.00;
        else if (amount <= 50000.00)
            return 62.00;
        else if (amount <= 100000.00)
            return 87.00;
        else if (amount <= 200000.00)
            return 112.00;
        else if (amount <= 500000.00)
            return 137.00;
        else
            return 162.00;
    }

    public Boolean getEazzyBankingTransferToOtherBankAccountRtgsMinMax(Double amount) {
        if (amount < 1.00 || amount > 100000.00)
            return false;
        else
            return true;
    }

    public Double getEazzyBankingTransferToOtherBankAccountRtgsRates() {
        return 300.00;
    }

    public Boolean getEazzyBankingTransferToEquityAccountMinMax(Double amount) {
        if (amount < 1.00 || amount > 300000.00)
            return false;
        else
            return true;
    }

    public Double getEazzyBankingTransferToEquityAccountRates() {
        return 30.00;
    }

    public Boolean getEazzyBankingAgentWithdrawalMinMax(Double amount) {
        if (amount < 100.00 || amount > 100000.00)
            return false;
        else
            return true;
    }

    public Double getEazzyBankingAgentWithdrawalRates(Double amount) {
        if (amount <= 2500.00)
            return 27.50;
        else if (amount <= 5000.00)
            return 37.50;
        else if (amount <= 10000.00)
            return 82.50;
        else if (amount <= 20000.00)
            return 159.50;
        else if (amount <= 35000.00)
            return 187.00;
        else if (amount <= 50000.00)
            return 214.50;
        else
            return 242.00;
    }

    public Double getEazzyBankingBillPaymentsRates() {
        return 30.00;
    }

    /*
    Airtel Money
     */
    public Boolean getAirtelMoneyMinMax(Double amount) {
        if (amount < 50.00 || amount > 70000.00)
            return false;
        else
            return true;
    }

    public Double getAirtelMoneyTransferRates() {
        return 0.00;
    }

    public Double getAirtelMoneyAgentWithdrawalRates(Double amount) {
        if (amount <= 100.00)
            return 10.00;
        else if (amount <= 2500.00)
            return 27.00;
        else if (amount <= 3500.00)
            return 49.00;
        else if (amount <= 5000.00)
            return 66.00;
        else if (amount <= 7500.00)
            return 82.00;
        else if (amount <= 10000.00)
            return 110.00;
        else if (amount <= 15000.00)
            return 159.00;
        else if (amount <= 20000.00)
            return 176.00;
        else if (amount <= 35000.00)
            return 187.00;
        else if (amount <= 50000.00)
            return 275.00;
        else
            return 330.00;
    }

    public Double getAirtelMoneyChaseBankATMWithdrawalRates() {
        return 30.00;
    }

    public Double getAirtelMoneyKenswitchATMWithdrawalRates() {
        return 50.00;
    }

    public Double getAirtelMoneyVisaLocalATMWithdrawalRates() {
        return 50.00;
    }

    public Double getAirtelMoneyVisaInternationalATMWithdrawalRates() {
        return 250.00;
    }

    /*
    M-Pesa
     */
    public Boolean getMpesaAgentWithdrawalMinMax(Double amount) {
        if (amount < 50.00 || amount > 70000.00)
            return false;
        else
            return true;
    }

    public Double getMpesaAgentWithdrawalRates(Double amount) {
        if (amount <= 100.00)
            return 10.00;
        else if (amount <= 2500.00)
            return 27.00;
        else if (amount <= 3500.00)
            return 49.00;
        else if (amount <= 5000.00)
            return 66.00;
        else if (amount <= 7500.00)
            return 82.00;
        else if (amount <= 10000.00)
            return 110.00;
        else if (amount <= 15000.00)
            return 159.00;
        else if (amount <= 20000.00)
            return 176.00;
        else if (amount <= 35000.00)
            return 187.00;
        else if (amount <= 50000.00)
            return 275.00;
        else
            return 330.00;
    }

    public Boolean getMpesaTransferToUnregisteredUsersMinMax(Double amount) {
        if (amount <= 100.00 || amount > 35000.00)
            return false;
        else
            return true;
    }

    public Double getMpesaTransferToUnregisteredUsersRates(Double amount) {
        if (amount <= 500.00)
            return 44.00;
        else if (amount <= 1000.00)
            return 48.00;
        else if (amount <= 1500.00)
            return 58.00;
        else if (amount <= 2500.00)
            return 73.00;
        else if (amount <= 3500.00)
            return 110.00;
        else if (amount <= 5000.00)
            return 132.00;
        else if (amount <= 7500.00)
            return 163.00;
        else if (amount <= 10000.00)
            return 201.00;
        else if (amount <= 15000.00)
            return 260.00;
        else if (amount <= 20000.00)
            return 282.00;
        else
            return 303.00;
    }

    public Boolean getMpesaTransferToRegisteredUsersMinMax(Double amount) {
        if (amount < 1.00 || amount > 70000.00)
            return false;
        else
            return true;
    }

    public Double getMpesaTransferToRegisteredUsersRates(Double amount) {
        if (amount <= 100.00)
            return 0.00;
        else if (amount <= 500.00)
            return 11.00;
        else if (amount <= 1000.00)
            return 15.00;
        else if (amount <= 1500.00)
            return 25.00;
        else if (amount <= 2500.00)
            return 40.00;
        else if (amount <= 3500.00)
            return 55.00;
        else if (amount <= 5000.00)
            return 60.00;
        else if (amount <= 7500.00)
            return 75.00;
        else if (amount <= 10000.00)
            return 85.00;
        else if (amount <= 15000.00)
            return 95.00;
        else if (amount <= 20000.00)
            return 100.00;
        else
            return 110.00;
    }

    public Boolean getMpesaATMWithdrawalMinMax(Double amount) {
        if (amount < 200.00 || amount > 20000.00)
            return false;
        else
            return true;
    }

    public Double getMPesaATMWithdrawalRates(Double amount) {
        if (amount <= 2500.00)
            return 33.00;
        else if (amount <= 5000.00)
            return 66.00;
        else if (amount <= 10000.00)
            return 110.00;
        else
            return 193.00;
    }


}
