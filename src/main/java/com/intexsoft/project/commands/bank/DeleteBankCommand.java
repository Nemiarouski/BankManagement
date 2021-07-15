package com.intexsoft.project.commands.bank;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.utils.ConsoleHelper;

public class DeleteBankCommand implements Command {
    private final ConsoleHelper consoleHelper;
    private final BankService bankService;

    public DeleteBankCommand(ConsoleHelper consoleHelper, BankService bankService) {
        this.consoleHelper = consoleHelper;
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