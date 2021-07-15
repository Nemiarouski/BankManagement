package com.intexsoft.project.entities;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private String bankName;
    private double rate;
    private Map<Account, Client> database = new HashMap<>();

    public Bank() {}
    public Bank(String bankName, double rate) {
        this.bankName = bankName;
        this.rate = rate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Map<Account, Client> getDatabase() {
        return database;
    }

    public void setDatabase(Map<Account, Client> database) {
        this.database = database;
    }

    @Override
    public String toString() {
        return  "[Bank Name]: "
                + bankName
                + " [Rate]: "
                + rate
                + " [Database]: "
                + database;
    }
}