package com.intexsoft.project.repositories;

import com.intexsoft.project.entities.Bank;
import java.util.List;

public class BankRepository extends AbstractRepository<Bank> {

    @Override
    protected String filepath() {
        return "banks.json";
    }

    public void createEntity(String bankName, double legalRate, double individualRate) {
        Bank bank = new Bank(bankName, legalRate, individualRate);
        addEntity(bank);
    }

    public void updateEntity(int choice, String name, double legalRate, double individualRate) {
        List<Bank> banks = getEntities();
        Bank bankToUpdate = banks.get(choice - 1);
        bankToUpdate.setBankName(name);
        bankToUpdate.setLegalRate(legalRate);
        bankToUpdate.setIndividualRate(individualRate);
    }
}