package com.intexsoft.project.entities;

public enum CurrencyType {
    DOLLAR(2.55), EURO(3.09), RUBLE(100.0), BELRUBLE(1.0);

    private double currency;

    CurrencyType(double currency) {
        this.currency = currency;
    }

    public double getCurrency() {
        return currency;
    }
}