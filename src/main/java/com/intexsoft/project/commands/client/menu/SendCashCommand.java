package com.intexsoft.project.commands.client.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Client;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;
import java.util.List;

public class SendCashCommand implements Command {
    private final ConsoleHelper consoleHelper;
    private final ClientService clientService;
    private final BankService bankService;

    public SendCashCommand(ConsoleHelper consoleHelper, ClientService clientService, BankService bankService) {
        this.consoleHelper = consoleHelper;
        this.clientService = clientService;
        this.bankService = bankService;
    }

    @Override
    public String name() {
        return "Send Cash";
    }

    @Override
    public void execute() {
        List<Client> clients = clientService.getEntities();
        if (clients.isEmpty()) {
            System.out.println("Client list is empty. Create new one.");
        }

        System.out.println("Choose client to send money:");
        consoleHelper.show(clients);
        int choice = consoleHelper.validateIntToValue(clients.size());
        Client client = clients.get(choice - 1);

        if (!client.getAccounts().isEmpty()) {

        } else {
            System.out.println("Client hasn't have an accounts yet.");
        }

    }
}