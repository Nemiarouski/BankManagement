package com.intexsoft.project.commands.bank;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;

public class DeleteBankCommand implements Command {
    private final BankService bankService;

    public DeleteBankCommand(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public String name() {
        return "Delete Bank";
    }

    @Override
    public void execute() {

    }
}