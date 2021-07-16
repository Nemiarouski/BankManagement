package com.intexsoft.project.entities;

import java.math.BigDecimal;

public class Transaction {
    private Account fromAccount;
    private Account toAccount;
    private BigDecimal cash;

    public Transaction() {}
    public Transaction(Account fromAccount, Account toAccount, BigDecimal cash) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.cash = cash;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", cash=" + cash +
                '}';
    }
}