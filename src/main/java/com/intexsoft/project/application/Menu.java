package com.intexsoft.project.application;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.commands.ExitCommand;
import com.intexsoft.project.commands.bank.BankCommands;
import com.intexsoft.project.commands.client.ClientCommands;
import com.intexsoft.project.manager.Manager;
import com.intexsoft.project.repositories.BankRepository;
import com.intexsoft.project.repositories.ClientRepository;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Command> menuCommands = new ArrayList<>();
    private final ConsoleHelper consoleHelper = new ConsoleHelper();
    private final ClientRepository clientRepository = new ClientRepository();
    private final BankRepository bankRepository = new BankRepository();
    private final ClientService clientService = new ClientService(clientRepository);
    private final BankService bankService = new BankService(bankRepository);
    private final Manager manager = new Manager();

    private void startApp() {
        int choice;
        Command command;
        do {
            showMenu();
            choice = consoleHelper.validateIntToValue(menuCommands.size());
            command = menuCommands.get(choice - 1);
            manager.work(command);
        } while (!command.name().equals("Exit"));
    }

    private void fillMenuCommands() {
        addCommand(menuCommands, new BankCommands(consoleHelper, bankService));
        addCommand(menuCommands, new ClientCommands(consoleHelper, clientService));
        addCommand(menuCommands, new ExitCommand());
    }

    private void showMenu() {
        for (int i = 0; i < menuCommands.size(); i++) {
            System.out.println((i + 1) + ") " + menuCommands.get(i).name());
        }
    }

    private void addCommand(List<Command> commands, Command command) {
        commands.add(command);
    }

    public void start() {
        fillMenuCommands();
        startApp();
    }
}