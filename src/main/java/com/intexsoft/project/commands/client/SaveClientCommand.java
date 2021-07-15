package com.intexsoft.project.commands.client;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;

public class SaveClientCommand implements Command {
    private final ConsoleHelper consoleHelper;
    private final ClientService clientService;

    public SaveClientCommand(ConsoleHelper consoleHelper, ClientService clientService) {
        this.consoleHelper = consoleHelper;
        this.clientService = clientService;
    }

    @Override
    public String name() {
        return "Save Client";
    }

    @Override
    public void execute() {

    }
}