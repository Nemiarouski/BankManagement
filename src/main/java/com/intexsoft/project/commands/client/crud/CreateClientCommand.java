package com.intexsoft.project.commands.client.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.ClientType;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.CommandHelper;
import java.util.List;

public class CreateClientCommand implements Command {
    private final CommandHelper commandHelper;
    private final ClientService clientService;

    public CreateClientCommand(CommandHelper commandHelper, ClientService clientService) {
        this.commandHelper = commandHelper;
        this.clientService = clientService;
    }

    private ClientType getClientType(List<ClientType> clients) {
        int choice = commandHelper.validateIntToValue(clients.size());
        return clients.get(choice - 1);
    }

    private void showClientTypes(List<ClientType> clients) {
        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i + 1) + ") " + clients.get(i).getType());
        }
    }

    @Override
    public String getName() {
        return "Create Client";
    }

    @Override
    public void execute() {
        System.out.println("Input client name:");
        String clientName = commandHelper.read();

        List<ClientType> clientTypes = List.of(ClientType.values());
        showClientTypes(clientTypes);

        System.out.println("Choose client type:");
        ClientType clientType = getClientType(clientTypes);

        clientService.createClient(clientName, clientType);
    }
}