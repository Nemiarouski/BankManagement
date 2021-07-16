package com.intexsoft.project.commands.client.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;
import java.util.List;

public class ClientCrudCommands implements Command {
    private final ConsoleHelper consoleHelper;
    private final List<Command> clientCommands;

    public ClientCrudCommands(ConsoleHelper consoleHelper, ClientService clientService) {
        this.consoleHelper = consoleHelper;
        clientCommands = List.of(
                new CreateClientCommand(consoleHelper, clientService),
                new DeleteClientCommand(consoleHelper, clientService),
                new UpdateClientCommand(consoleHelper, clientService),
                new ShowClientsCommand(consoleHelper, clientService),
                new SaveClientCommand(clientService),
                new DownloadClientCommand(clientService));
    }

    private void showCommands() {
        for (int i = 0; i < clientCommands.size(); i++) {
            System.out.println((i + 1) + ") " + clientCommands.get(i).name());
        }
    }

    private void chooseCommand() {
        int choice = consoleHelper.validateIntToValue(clientCommands.size());
        clientCommands.get(choice - 1).execute();
    }

    @Override
    public String name() {
        return "Client Crud Menu";
    }

    @Override
    public void execute() {
        showCommands();
        chooseCommand();
    }
}