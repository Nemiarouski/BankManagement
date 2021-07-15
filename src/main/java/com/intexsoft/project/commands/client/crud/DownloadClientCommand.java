package com.intexsoft.project.commands.client.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;

public class DownloadClientCommand implements Command {
    private final ConsoleHelper consoleHelper;
    private final ClientService clientService;

    public DownloadClientCommand(ConsoleHelper consoleHelper, ClientService clientService) {
        this.consoleHelper = consoleHelper;
        this.clientService = clientService;
    }

    @Override
    public String name() {
        return "Download Client";
    }

    @Override
    public void execute() {

    }
}