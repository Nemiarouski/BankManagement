package com.intexsoft.project.commands.client.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;

public class ShowAccountsCommand implements Command {
    private final ConsoleHelper consoleHelper;
    private final ClientService clientService;

    public ShowAccountsCommand(ConsoleHelper consoleHelper, ClientService clientService) {
        this.consoleHelper = consoleHelper;
        this.clientService = clientService;
    }

    @Override
    public String name() {
        return "Show Accounts";
    }

    @Override
    public void execute() {

    }
}