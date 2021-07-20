package com.intexsoft.project.commands.client.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.ClientService;

public class DownloadClientCommand implements Command {
    private final ClientService clientService;

    public DownloadClientCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String getName() {
        return "Download Client";
    }

    @Override
    public void execute() {
        clientService.download();
    }

    @Override
    public String describe() {
        return "Download all clients from json file.";
    }
}