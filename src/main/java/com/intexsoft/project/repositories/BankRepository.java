package com.intexsoft.project.repositories;

import com.intexsoft.project.entities.Bank;

public class BankRepository extends AbstractRepository<Bank> {

    @Override
    protected String filepath() {
        return "banks.json";
    }

    public void createEntity(String bankName, double legalRate, double individualRate) {
        Bank bank = new Bank(bankName, legalRate, individualRate);
        addEntity(bank);
    }
}