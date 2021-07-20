package com.intexsoft.project.commands.client.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Client;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.CommandHelper;
import java.util.List;

public class DeleteClientCommand implements Command {
    private final CommandHelper commandHelper;
    private final ClientService clientService;

    public DeleteClientCommand(CommandHelper commandHelper, ClientService clientService) {
        this.commandHelper = commandHelper;
        this.clientService = clientService;
    }

    private Client getClientToDelete(List<Client> clients) {
        int choice = commandHelper.validateIntToValue(clients.size());
        return clients.get(choice - 1);
    }

    @Override
    public String getName() {
        return "Delete Client";
    }

    @Override
    public void execute() {
        List<Client> clients = clientService.getEntities();
        commandHelper.show(clients);

        System.out.println("Input client to delete:");
        Client client = getClientToDelete(clients);

        clientService.deleteEntity(client);
    }

    @Override
    public String describe() {
        return "Delete client from client system.";
    }
}