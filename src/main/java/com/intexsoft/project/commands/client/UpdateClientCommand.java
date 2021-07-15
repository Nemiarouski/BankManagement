package com.intexsoft.project.commands.client;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.ClientService;

public class UpdateClientCommand implements Command {
    private final ClientService clientService;

    public UpdateClientCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String name() {
        return "Update Client";
    }

    @Override
    public void execute() {

    }
}