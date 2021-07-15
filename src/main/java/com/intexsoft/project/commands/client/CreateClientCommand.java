package com.intexsoft.project.commands.client;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.ClientService;

public class CreateClientCommand implements Command {
    private final ClientService clientService;

    public CreateClientCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String name() {
        return "Create Client";
    }

    @Override
    public void execute() {

    }
}