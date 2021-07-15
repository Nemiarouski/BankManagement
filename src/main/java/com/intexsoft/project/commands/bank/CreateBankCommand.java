package com.intexsoft.project.commands.bank;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;

public class CreateBankCommand implements Command {
    private final BankService bankService;

    public CreateBankCommand(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public String name() {
        return "Create Bank";
    }

    @Override
    public void execute() {

    }
}