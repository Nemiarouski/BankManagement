package com.intexsoft.project.services;

import com.intexsoft.project.entities.Bank;
import com.intexsoft.project.repositories.BankRepository;

public class BankService extends AbstractService<Bank, BankRepository> {

    public BankService(BankRepository bankRepository) {
        super(bankRepository);
    }

    public void createBank(String bankName, double legalRate, double individualRate) {
        getT().createEntity(bankName, legalRate, individualRate);
    }

    public void updateBank(int choice, String bankName, double legalRate, double individualRate) {
        getT().updateEntity(choice, bankName, legalRate, individualRate);
    }
}