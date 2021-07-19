package com.intexsoft.project.commands.client.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.CommandHelper;
import java.util.List;

public class ClientCrudCommands implements Command {
    private final CommandHelper commandHelper;
    private final List<Command> clientCommands;

    public ClientCrudCommands(CommandHelper commandHelper, ClientService clientService) {
        this.commandHelper = commandHelper;
        clientCommands = List.of(
                new CreateClientCommand(commandHelper, clientService),
                new DeleteClientCommand(commandHelper, clientService),
                new UpdateClientCommand(commandHelper, clientService),
                new ShowClientsCommand(commandHelper, clientService),
                new SaveClientCommand(clientService),
                new DownloadClientCommand(clientService));
    }

    private void showCommands() {
        for (int i = 0; i < clientCommands.size(); i++) {
            System.out.println((i + 1) + ") " + clientCommands.get(i).getName());
        }
    }

    private void chooseCommand() {
        int choice = commandHelper.validateIntToValue(clientCommands.size());
        clientCommands.get(choice - 1).execute();
    }

    @Override
    public String getName() {
        return "Client Crud Menu";
    }

    @Override
    public void execute() {
        showCommands();
        chooseCommand();
    }
}