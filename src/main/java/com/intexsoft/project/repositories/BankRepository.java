package com.intexsoft.project.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intexsoft.project.entities.Bank;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BankRepository {
    private final static File FILE = new File("banks.json");
    private List<Bank> banks = new ArrayList<>();

    public void createBank() {
        //create new Bank();
    }

    public void addBank(Bank bank) {
        banks.add(bank);
    }

    public void deleteBank(Bank bank) {
        banks.remove(bank);
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void save() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(FILE, banks);
    }

    public void download() throws IOException {
        if (FILE.exists() && FILE.length() > 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            banks = objectMapper.readValue(FILE, new TypeReference<>(){});
            //second variant banks = List.of(objectMapper.readValue(FILE, Bank[].class));
        }
    }
}