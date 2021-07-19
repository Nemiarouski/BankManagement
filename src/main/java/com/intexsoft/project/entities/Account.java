package com.intexsoft.project.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    private String bankName;
    private CurrencyType currencyType;
    private BigDecimal cash;
    private List<Transaction> transactions = new ArrayList<>();

    public Account() {}
    public Account(String bankName, CurrencyType currencyType) {
        this.bankName = bankName;
        this.currencyType = currencyType;
        this.cash = new BigDecimal("0");
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
        return cash.setScale(3, RoundingMode.HALF_DOWN);
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addCash(BigDecimal cash) {
        this.cash = this.cash.add(cash);
    }

    public void deleteCash(BigDecimal cash) {
        this.cash = this.cash.subtract(cash);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(bankName, account.bankName) && currencyType == account.currencyType && Objects.equals(cash, account.cash) && Objects.equals(transactions, account.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, currencyType, cash, transactions);
    }

    @Override
    public String toString() {
        return "[" + bankName + "]:"
                + " [Currency Type]: "
                + currencyType
                + " [Cash]: "
                + cash.setScale(3, RoundingMode.HALF_DOWN)
                + " [Transaction History]: "
                + transactions;
    }
}