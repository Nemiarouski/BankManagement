package com.intexsoft.project.commands.client.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Client;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;
import java.util.List;

public class ShowClientsCommand implements Command {
    private final ConsoleHelper consoleHelper;
    private final ClientService clientService;

    public ShowClientsCommand(ConsoleHelper consoleHelper, ClientService clientService) {
        this.consoleHelper = consoleHelper;
        this.clientService = clientService;
    }

    @Override
    public String name() {
        return "Show Clients";
    }

    @Override
    public void execute() {
        List<Client> clients = clientService.getEntities();
        consoleHelper.show(clients);
    }
}