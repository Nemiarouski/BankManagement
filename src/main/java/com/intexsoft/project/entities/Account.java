package com.intexsoft.project.entities;

import java.util.List;

public class Account {
    private CurrencyType currencyType;
    private double cash;
    private List<String> transactionHistory;

    public Account() {}
    public Account(CurrencyType currencyType) {
        this.currencyType = currencyType;
        this.cash = 0;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
}