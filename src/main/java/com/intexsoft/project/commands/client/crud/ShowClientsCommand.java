package com.intexsoft.project.commands.client.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Client;
import com.intexsoft.project.services.ClientService;
import java.util.List;

public class ShowClientsCommand implements Command {
    private final ClientService clientService;

    public ShowClientsCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String name() {
        return "Show Clients";
    }

    @Override
    public void execute() {
        List<Client> clients = clientService.getEntities();
        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i + 1) + ") " + clients.get(i));
        }
    }
}