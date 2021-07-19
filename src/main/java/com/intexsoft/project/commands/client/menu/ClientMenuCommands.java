package com.intexsoft.project.commands.client.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.CommandHelper;
import java.util.List;

public class ClientMenuCommands implements Command {
    private final CommandHelper commandHelper;
    private final List<Command> clientCommands;

    public ClientMenuCommands(CommandHelper commandHelper, BankService bankService, ClientService clientService) {
        this.commandHelper = commandHelper;
        this.clientCommands = List.of(
                new DepositCashCommand(clientService, commandHelper),
                new WithdrawCashCommand(clientService, commandHelper),
                new SendCashCommand(commandHelper, clientService, bankService),
                new ClientAccountsCommand(commandHelper, clientService),
                new ClientTransactionsCommand(commandHelper, clientService));
    }

    private void show() {
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
        return "Client Menu";
    }

    @Override
    public void execute() {
        show();
        chooseCommand();
    }
}