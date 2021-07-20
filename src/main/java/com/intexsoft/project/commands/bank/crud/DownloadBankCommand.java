package com.intexsoft.project.commands.bank.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;

public class DownloadBankCommand implements Command {
    private final BankService bankService;

    public DownloadBankCommand(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public String getName() {
        return "Download Bank";
    }

    @Override
    public void execute() {
        bankService.download();
    }

    @Override
    public String describe() {
        return "Download all banks from json file.";
    }
}