package com.intexsoft.project.commands.client;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.ClientService;

public class DeleteClientCommand implements Command {
    private final ClientService clientService;

    public DeleteClientCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String name() {
        return "Delete Client";
    }

    @Override
    public void execute() {

    }
}