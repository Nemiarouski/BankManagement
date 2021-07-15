package com.intexsoft.project.commands.bank.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.utils.ConsoleHelper;

public class DownloadBankCommand implements Command {
    private final ConsoleHelper consoleHelper;
    private final BankService bankService;

    public DownloadBankCommand(ConsoleHelper consoleHelper, BankService bankService) {
        this.consoleHelper = consoleHelper;
        this.bankService = bankService;
    }

    @Override
    public String name() {
        return "Download Bank";
    }

    @Override
    public void execute() {

    }
}