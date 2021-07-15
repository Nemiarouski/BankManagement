package com.intexsoft.project.repositories;

import com.intexsoft.project.entities.Bank;

public class BankRepository extends AbstractRepository<Bank> {

    @Override
    protected String filepath() {
        return "banks.json";
    }


}