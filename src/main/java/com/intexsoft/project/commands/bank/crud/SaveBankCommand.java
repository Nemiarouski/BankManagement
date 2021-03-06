package com.intexsoft.project.commands.bank.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;

public class SaveBankCommand implements Command {
    private final BankService bankService;

    public SaveBankCommand(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public String getName() {
        return "Save Bank";
    }

    @Override
    public void execute() {
        bankService.save();
    }

    @Override
    public String describe() {
        return "Save bank to the json file.";
    }
}