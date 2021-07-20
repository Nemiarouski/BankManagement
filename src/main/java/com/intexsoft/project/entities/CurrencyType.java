package com.intexsoft.project.entities;

public enum CurrencyType {
    DOLLAR(2.54), EURO(2.99), RUBLE(0.034), BELRUBLE(1.0);

    private final double currency;

    CurrencyType(double currency) {
        this.currency = currency;
    }

    public double getCurrency() {
        return currency;
    }
}