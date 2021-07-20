package com.intexsoft.project.commands.client.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.ClientService;

public class SaveClientCommand implements Command {
    private final ClientService clientService;

    public SaveClientCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String getName() {
        return "Save Clients";
    }

    @Override
    public void execute() {
        clientService.save();
    }

    @Override
    public String describe() {
        return "Save all clients in json file.";
    }
}