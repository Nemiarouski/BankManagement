package com.intexsoft.project.commands.client.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.ClientType;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;
import java.util.List;

public class CreateClientCommand implements Command {
    private final ConsoleHelper consoleHelper;
    private final ClientService clientService;

    public CreateClientCommand(ConsoleHelper consoleHelper, ClientService clientService) {
        this.consoleHelper = consoleHelper;
        this.clientService = clientService;
    }

    private ClientType getClientType(List<ClientType> clients) {
        int choice = consoleHelper.validateIntToValue(clients.size());
        return clients.get(choice - 1);
    }

    private void showClientTypes(List<ClientType> clients) {
        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i + 1) + ") " + clients.get(i).getType());
        }
    }

    @Override
    public String name() {
        return "Create Client";
    }

    @Override
    public void execute() {
        List<ClientType> clients = List.of(ClientType.values());
        showClientTypes(clients);

        System.out.println("\nChoose client type:");
        ClientType clientType = getClientType(clients);

        System.out.println("Input client name:");
        String name = consoleHelper.read();

        clientService.createClient(name, clientType);
    }
}