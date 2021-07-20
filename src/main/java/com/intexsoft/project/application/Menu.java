package com.intexsoft.project.application;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.commands.ExitCommand;
import com.intexsoft.project.commands.HelpCommand;
import com.intexsoft.project.commands.bank.crud.BankCrudCommand;
import com.intexsoft.project.commands.bank.menu.BankMenuCommand;
import com.intexsoft.project.commands.client.crud.ClientCrudCommand;
import com.intexsoft.project.commands.client.menu.ClientMenuCommand;
import com.intexsoft.project.manager.Manager;
import com.intexsoft.project.repositories.BankRepository;
import com.intexsoft.project.repositories.ClientRepository;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.CommandHelper;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Command> menuCommands = new ArrayList<>();
    private final CommandHelper commandHelper = new CommandHelper();
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
            choice = commandHelper.validateIntToValue(menuCommands.size());
            command = menuCommands.get(choice - 1);
            manager.work(command);
        } while (!command.getName().equals("Exit"));
    }

    private void fillMenuCommands() {
        addCommand(menuCommands, new BankCrudCommand(commandHelper, bankService));
        addCommand(menuCommands, new ClientCrudCommand(commandHelper, clientService));
        addCommand(menuCommands, new BankMenuCommand(commandHelper, clientService, bankService));
        addCommand(menuCommands, new ClientMenuCommand(commandHelper, bankService, clientService));
        addCommand(menuCommands, new HelpCommand(commandHelper, clientService, bankService));
        addCommand(menuCommands, new ExitCommand());
    }

    private void showMenu() {
        for (int i = 0; i < menuCommands.size(); i++) {
            System.out.println((i + 1) + ") " + menuCommands.get(i).getName());
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