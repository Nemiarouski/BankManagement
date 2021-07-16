package com.intexsoft.project.entities;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private String bankName;
    private double legalRate;
    private double individualRate;
    private Map<Account, Client> database = new HashMap<>();

    public Bank() {}
    public Bank(String bankName, double legalRate, double individualRate) {
        this.bankName = bankName;
        this.legalRate = legalRate;
        this.individualRate = individualRate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getLegalRate() {
        return legalRate;
    }

    public void setLegalRate(double legalRate) {
        this.legalRate = legalRate;
    }

    public double getIndividualRate() {
        return individualRate;
    }

    public void setIndividualRate(double individualRate) {
        this.individualRate = individualRate;
    }

    public Map<Account, Client> getDatabase() {
        return database;
    }

    public void setDatabase(Map<Account, Client> database) {
        this.database = database;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", legalRate=" + legalRate +
                ", individualRate=" + individualRate +
                ", database=" + database +
                '}';
    }
}