package com.intexsoft.project.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    private String bankName;
    private CurrencyType currencyType;
    private BigDecimal cash;
    private List<Transaction> transactionHistory = new ArrayList<>();

    public Account() {}
    public Account(String bankName, CurrencyType currencyType) {
        this.bankName = bankName;
        this.currencyType = currencyType;
        this.cash = BigDecimal.valueOf(0);
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(bankName, account.bankName) && currencyType == account.currencyType && Objects.equals(cash, account.cash) && Objects.equals(transactionHistory, account.transactionHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, currencyType, cash, transactionHistory);
    }

    @Override
    public String toString() {
        return "[" + bankName + "]:"
                + " [Currency Type]: "
                + currencyType
                + " [Cash]: "
                + cash
                + " [Transaction History]: "
                + transactionHistory;
    }
}