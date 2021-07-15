package com.intexsoft.project.commands.client.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;
import java.util.List;

public class ClientMenuCommands implements Command {
    private final ConsoleHelper consoleHelper;
    private final List<Command> clientCommands;

    public ClientMenuCommands(ConsoleHelper consoleHelper, ClientService clientService) {
        this.consoleHelper = consoleHelper;
        this.clientCommands = List.of(
                new SendCashCommand(consoleHelper, clientService),
                new ShowAccountsCommand(consoleHelper, clientService),
                new ShowTransactionsCommands(consoleHelper, clientService)
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