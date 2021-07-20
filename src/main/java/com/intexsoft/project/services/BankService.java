package com.intexsoft.project.services;

import com.intexsoft.project.entities.Bank;
import com.intexsoft.project.repositories.BankRepository;
import java.util.List;

public class BankService extends AbstractService<Bank, BankRepository> {

    public BankService(BankRepository bankRepository) {
        super(bankRepository);
    }

    public void createBank(String bankName, double legalRate, double individualRate) {
        Bank bank = new Bank(bankName, legalRate, individualRate);
        getT().createEntity(bank);
    }

    public void updateBank(int choice, String bankName, double legalRate, double individualRate) {
        List<Bank> banks = getEntities();
        Bank bankToUpdate = banks.get(choice - 1);

        bankToUpdate.setBankName(bankName);
        bankToUpdate.setLegalRate(legalRate);
        bankToUpdate.setIndividualRate(individualRate);

        getT().updateEntity(choice, bankToUpdate);
    }
}