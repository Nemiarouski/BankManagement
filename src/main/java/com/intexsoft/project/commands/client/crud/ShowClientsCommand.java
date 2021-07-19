package com.intexsoft.project.commands.client.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Client;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.CommandHelper;
import java.util.List;

public class ShowClientsCommand implements Command {
    private final CommandHelper commandHelper;
    private final ClientService clientService;

    public ShowClientsCommand(CommandHelper commandHelper, ClientService clientService) {
        this.commandHelper = commandHelper;
        this.clientService = clientService;
    }

    @Override
    public String getName() {
        return "Show Clients";
    }

    @Override
    public void execute() {
        List<Client> clients = clientService.getEntities();
        commandHelper.show(clients);
    }
}