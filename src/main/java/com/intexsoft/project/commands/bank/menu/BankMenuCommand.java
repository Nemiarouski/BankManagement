package com.intexsoft.project.commands.bank.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;
import java.util.List;

public class BankMenuCommand implements Command {
    private final ConsoleHelper consoleHelper;
    private final List<Command> bankCommands;

    public BankMenuCommand(ConsoleHelper consoleHelper, ClientService clientService, BankService bankService) {
        this.consoleHelper = consoleHelper;
        this.bankCommands = List.of(
                new AddClientToBankCommand(bankService, clientService, consoleHelper),
                new DeleteClientAccountCommand(bankService, clientService, consoleHelper));
    }

    private void showCommands() {
        for (int i = 0; i < bankCommands.size(); i++) {
            System.out.println((i + 1) + ") " + bankCommands.get(i).name());
        }
    }

    private void chooseCommand() {
        int choice = consoleHelper.validateIntToValue(bankCommands.size());
        bankCommands.get(choice - 1).execute();
    }

    @Override
    public String name() {
        return "Bank Menu";
    }

    @Override
    public void execute() {
        showCommands();
        chooseCommand();
    }
}