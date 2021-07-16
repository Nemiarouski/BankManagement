package com.intexsoft.project.commands.client.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.commands.client.crud.CreateClientCommand;
import com.intexsoft.project.entities.Account;
import com.intexsoft.project.entities.Client;
import com.intexsoft.project.entities.Transaction;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;
import java.util.List;

public class ShowTransactionsCommands implements Command {
    private final ConsoleHelper consoleHelper;
    private final ClientService clientService;
    private final CreateClientCommand createClientCommand;

    public ShowTransactionsCommands(ConsoleHelper consoleHelper, ClientService clientService) {
        this.consoleHelper = consoleHelper;
        this.clientService = clientService;
        this.createClientCommand = new CreateClientCommand(consoleHelper, clientService);
    }

    @Override
    public String name() {
        return "Show Transactions";
    }

    @Override
    public void execute() {
        List<Client> clients = clientService.getEntities();
        if (clients.isEmpty()) {
            System.out.println("Client list is empty. Create new one.");
            createClientCommand.execute();
        }
        consoleHelper.show(clients);

        System.out.println("Choose client to show transactions:");
        int choice = consoleHelper.validateIntToValue(clients.size());
        Client client = clients.get(choice - 1);

        List<Account> accounts = client.getAccounts();
        if (!accounts.isEmpty()) {
            for (Account account : accounts) {
                System.out.println(account);
            }
            System.out.println("Which account transactions to show:");
            int accountChoice = consoleHelper.validateIntToValue(accounts.size());
            Account account = accounts.get(accountChoice - 1);

            List<Transaction> transactions = account.getTransactionHistory();
            if (!transactions.isEmpty()) {
                for (Transaction transaction : transactions) {
                    System.out.println(transaction);
                }
            } else {
                System.out.println("Nothing to show.");
            }
        } else {
            System.out.println("Nothing to show");
        }
    }
}