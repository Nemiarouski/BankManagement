package com.intexsoft.project.services;

import com.intexsoft.project.entities.Bank;
import com.intexsoft.project.repositories.BankRepository;
import java.io.IOException;
import java.util.List;

public class BankService {
    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public void createBank(String bankName, double legalRate, double individualRate) {
        bankRepository.createEntity(bankName, legalRate, individualRate);
    }

    public void updateBank(int choice, String bankName, double legalRate, double individualRate) {
        bankRepository.updateEntity(choice, bankName, legalRate, individualRate);
    }

    public void deleteBank(Bank bank) {
        bankRepository.deleteEntity(bank);
    }

    public List<Bank> getBanks() {
        return bankRepository.getEntities();
    }

    public void save() {
        try {
            bankRepository.saveEntities();
        } catch (IOException e) {
            System.err.println("We have some problems with: " + e);
        }
    }

    public void download() {
        try {
            bankRepository.downloadEntities();
        } catch (IOException e) {
            System.err.println("We have some problems with: " + e);
        }
    }
}