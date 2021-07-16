package com.intexsoft.project.commands.client.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;
import java.util.List;

public class ClientMenuCommands implements Command {
    private final ConsoleHelper consoleHelper;
    private final List<Command> clientCommands;

    public ClientMenuCommands(ConsoleHelper consoleHelper, BankService bankService, ClientService clientService) {
        this.consoleHelper = consoleHelper;
        this.clientCommands = List.of(
                new DepositCashCommand(bankService, clientService, consoleHelper),
                new WithdrawCashCommand(),
                new SendCashCommand(consoleHelper, clientService, bankService),
                new ClientAccountsCommand(consoleHelper, clientService),
                new ClientTransactionsCommand(consoleHelper, clientService)
        );
    }

    private void show() {
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
        return "Client Menu";
    }

    @Override
    public void execute() {
        show();
        chooseCommand();
    }
}