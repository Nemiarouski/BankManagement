package com.intexsoft.project.commands.bank.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.services.ClientService;

public class DownloadDatabaseCommand implements Command {
    private final ClientService clientService;
    private final BankService bankService;

    public DownloadDatabaseCommand(ClientService clientService, BankService bankService) {
        this.clientService = clientService;
        this.bankService = bankService;
    }

    @Override
    public String getName() {
        return "Download Database";
    }

    @Override
    public void execute() {
        clientService.download();
        bankService.download();
    }

    @Override
    public String describe() {
        return "Download all information about banks and clients in one moment.";
    }
}
