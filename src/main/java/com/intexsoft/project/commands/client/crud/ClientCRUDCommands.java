package com.intexsoft.project.commands.client.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;

import java.util.List;

public class ClientCRUDCommands implements Command {
    private final List<Command> clientCommands;
    private final ConsoleHelper consoleHelper;

    public ClientCRUDCommands(ConsoleHelper consoleHelper, ClientService clientService) {
        this.consoleHelper = consoleHelper;
        clientCommands = List.of(
                new CreateClientCommand(consoleHelper, clientService),
                new DeleteClientCommand(consoleHelper, clientService),
                new UpdateClientCommand(consoleHelper, clientService),
                new ShowClientsCommand(clientService),
                new DownloadClientCommand(consoleHelper, clientService),
                new SaveClientCommand(consoleHelper, clientService)
        );
    }

    @Override
    public String name() {
        return "Client Menu";
    }

    @Override
    public void execute() {
        for (int i = 0; i < clientCommands.size(); i++) {
            System.out.println((i + 1) + ") " + clientCommands.get(i).name());
        }
        int choice = consoleHelper.validateIntToValue(clientCommands.size());
        clientCommands.get(choice - 1).execute();
    }
}