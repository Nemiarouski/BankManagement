package com.intexsoft.project.commands.client.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Client;
import com.intexsoft.project.entities.ClientType;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;
import java.util.List;

public class UpdateClientCommand implements Command {
    private final ConsoleHelper consoleHelper;
    private final ClientService clientService;

    public UpdateClientCommand(ConsoleHelper consoleHelper, ClientService clientService) {
        this.consoleHelper = consoleHelper;
        this.clientService = clientService;
    }

    private void show(List<Client> clients) {
        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i + 1) + ") " + clients.get(i));
        }
    }

    private void showClientTypes(List<ClientType> clients) {
        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i + 1) + ") " + clients.get(i).getType());
        }
    }

    private ClientType getClientType(List<ClientType> clients) {
        int choice = consoleHelper.validateIntToValue(clients.size());
        return clients.get(choice - 1);
    }

    @Override
    public String name() {
        return "Update Client";
    }

    @Override
    public void execute() {
        List<Client> clients = clientService.getEntities();
        show(clients);

        System.out.println("Choose client to update:");
        int choice = consoleHelper.validateIntToValue(clients.size());

        System.out.println("Input new client name:");
        String name = consoleHelper.read();

        List<ClientType> clientTypes = List.of(ClientType.values());
        showClientTypes(clientTypes);

        System.out.println("\nChoose new client type:");
        ClientType clientType = getClientType(clientTypes);

        clientService.updateClient(choice, name, clientType);
    }
}