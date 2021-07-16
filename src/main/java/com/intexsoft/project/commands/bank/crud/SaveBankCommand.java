package com.intexsoft.project.commands.bank.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;

public class SaveBankCommand implements Command {
    private final BankService bankService;

    public SaveBankCommand(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public String name() {
        return "Save Bank";
    }

    @Override
    public void execute() {
        bankService.save();
    }
}