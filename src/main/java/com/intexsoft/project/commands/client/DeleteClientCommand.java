package com.intexsoft.project.commands.client;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;

public class DeleteClientCommand implements Command {
    private final ConsoleHelper consoleHelper;
    private final ClientService clientService;

    public DeleteClientCommand(ConsoleHelper consoleHelper, ClientService clientService) {
        this.consoleHelper = consoleHelper;
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