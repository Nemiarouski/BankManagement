package com.intexsoft.project.commands.bank;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;

public class UpdateBankCommand implements Command {
    private final BankService bankService;

    public UpdateBankCommand(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public String name() {
        return "Update Bank";
    }

    @Override
    public void execute() {

    }
}