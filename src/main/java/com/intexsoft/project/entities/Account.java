package com.intexsoft.project.entities;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.cash, cash) == 0 && currencyType == account.currencyType && Objects.equals(transactionHistory, account.transactionHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyType, cash, transactionHistory);
    }

    @Override
    public String toString() {
        return "[Account]: "
                + " [Currency Type]: "
                + currencyType
                + "[Cash]: "
                + cash
                + " [Transaction History]: "
                + transactionHistory;
    }
}