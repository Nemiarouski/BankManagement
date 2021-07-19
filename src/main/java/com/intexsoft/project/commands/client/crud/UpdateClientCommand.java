package com.intexsoft.project.commands.client.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Client;
import com.intexsoft.project.entities.ClientType;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.CommandHelper;
import java.util.List;

public class UpdateClientCommand implements Command {
    private final CommandHelper commandHelper;
    private final ClientService clientService;

    public UpdateClientCommand(CommandHelper commandHelper, ClientService clientService) {
        this.commandHelper = commandHelper;
        this.clientService = clientService;
    }

    private void showClientTypes(List<ClientType> clients) {
        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i + 1) + ") " + clients.get(i).getType());
        }
    }

    private ClientType getClientType(List<ClientType> clients) {
        int choice = commandHelper.validateIntToValue(clients.size());
        return clients.get(choice - 1);
    }

    @Override
    public String getName() {
        return "Update Client";
    }

    @Override
    public void execute() {
        List<Client> clients = clientService.getEntities();
        commandHelper.show(clients);

        System.out.println("Choose client to update:");
        int choice = commandHelper.validateIntToValue(clients.size());

        System.out.println("Input new client name:");
        String name = commandHelper.read();

        List<ClientType> clientTypes = List.of(ClientType.values());
        showClientTypes(clientTypes);

        System.out.println("Choose new client type:");
        ClientType clientType = getClientType(clientTypes);

        clientService.updateClient(choice, name, clientType);
    }
}