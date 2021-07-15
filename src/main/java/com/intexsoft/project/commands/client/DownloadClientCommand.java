package com.intexsoft.project.commands.client;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.ClientService;

public class DownloadClientCommand implements Command {
    private final ClientService clientService;

    public DownloadClientCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String name() {
        return "Download Client";
    }

    @Override
    public void execute() {

    }
}