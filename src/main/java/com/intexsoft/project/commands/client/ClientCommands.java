package com.intexsoft.project.commands.client;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.ClientService;
import java.util.List;

public class ClientCommands implements Command {
    private final List<Command> clientCommands;

    public ClientCommands(ClientService clientService) {
        clientCommands = List.of(
                new CreateClientCommand(clientService),
                new DeleteClientCommand(clientService),
                new DownloadClientCommand(clientService),
                new SaveClientCommand(clientService),
                new UpdateClientCommand(clientService));
    }

    @Override
    public String name() {
        return "Client Menu";
    }

    @Override
    public void execute() {

    }
}