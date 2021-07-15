package com.intexsoft.project.commands.client;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.ClientService;

public class SaveClientCommand implements Command {
    private final ClientService clientService;

    public SaveClientCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String name() {
        return "Save Client";
    }

    @Override
    public void execute() {

    }
}