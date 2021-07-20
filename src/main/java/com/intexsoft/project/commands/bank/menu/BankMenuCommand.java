package com.intexsoft.project.commands.bank.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.CommandHelper;
import java.util.List;

public class BankMenuCommand implements Command {
    private final CommandHelper commandHelper;
    private final List<Command> bankCommands;

    public BankMenuCommand(CommandHelper commandHelper, ClientService clientService, BankService bankService) {
        this.commandHelper = commandHelper;
        this.bankCommands = List.of(
                new AddClientToBankCommand(bankService, clientService, commandHelper),
                new DeleteClientAccountCommand(bankService, clientService, commandHelper),
                new DownloadDatabaseCommand(clientService, bankService));
    }

    private void showCommands() {
        for (int i = 0; i < bankCommands.size(); i++) {
            System.out.println((i + 1) + ") " + bankCommands.get(i).getName());
        }
    }

    private void chooseCommand() {
        int choice = commandHelper.validateIntToValue(bankCommands.size());
        bankCommands.get(choice - 1).execute();
    }

    @Override
    public String getName() {
        return "Bank Menu";
    }

    @Override
    public void execute() {
        showCommands();
        chooseCommand();
    }

    @Override
    public String describe() {
        return "Show options which bank can offer to client.";
    }
}