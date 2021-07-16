package com.intexsoft.project.commands.client.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.commands.client.crud.CreateClientCommand;
import com.intexsoft.project.entities.Account;
import com.intexsoft.project.entities.Client;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;
import java.util.Comparator;
import java.util.List;

public class ClientAccountsCommand implements Command {
    private final ConsoleHelper consoleHelper;
    private final ClientService clientService;
    private final CreateClientCommand createClientCommand;

    public ClientAccountsCommand(ConsoleHelper consoleHelper, ClientService clientService) {
        this.consoleHelper = consoleHelper;
        this.clientService = clientService;
        this.createClientCommand = new CreateClientCommand(consoleHelper, clientService);
    }

    @Override
    public String name() {
        return "Client Accounts";
    }

    @Override
    public void execute() {
        List<Client> clients = clientService.getEntities();
        if (clients.isEmpty()) {
            System.out.println("Client list is empty. Create new one.");
            createClientCommand.execute();
        }

        consoleHelper.show(clients);

        System.out.println("Choose client to show accounts:");
        int choice = consoleHelper.validateIntToValue(clients.size());
        Client client = clients.get(choice - 1);

        List<Account> accounts = client.getAccounts();
        accounts.stream()
                .sorted(Comparator.comparing(Account::getBankName))
                .forEach(System.out::println);
    }
}