package com.intexsoft.project.commands.client.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.commands.client.crud.CreateClientCommand;
import com.intexsoft.project.entities.Account;
import com.intexsoft.project.entities.Client;
import com.intexsoft.project.entities.Transaction;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.CommandHelper;
import java.util.List;

public class ClientTransactionsCommand implements Command {
    private final CommandHelper commandHelper;
    private final ClientService clientService;
    private final CreateClientCommand createClientCommand;

    public ClientTransactionsCommand(CommandHelper commandHelper, ClientService clientService) {
        this.commandHelper = commandHelper;
        this.clientService = clientService;
        this.createClientCommand = new CreateClientCommand(commandHelper, clientService);
    }

    @Override
    public String getName() {
        return "Show Transactions";
    }

    @Override
    public void execute() {
        /*List<Client> clients = clientService.getEntities();
        if (clients.isEmpty()) {
            System.out.println("Client list is empty. Create new one.");
            createClientCommand.execute();
        }
        commandHelper.show(clients);

        System.out.println("Choose client to show transactions:");
        int choice = commandHelper.validateIntToValue(clients.size());
        Client client = clients.get(choice - 1);

        List<Account> accounts = client.getAccounts();
        if (!accounts.isEmpty()) {
            for (Account account : accounts) {
                System.out.println(account);
            }
            System.out.println("Which account transactions to show:");
            int accountChoice = commandHelper.validateIntToValue(accounts.size());
            Account account = accounts.get(accountChoice - 1);

            List<Transaction> transactions = account.getTransactions();
            if (!transactions.isEmpty()) {
                for (Transaction transaction : transactions) {
                    System.out.println(transaction);
                }
            } else {
                System.out.println("Nothing to show.");
            }
        } else {
            System.out.println("Nothing to show");
        }*/
        System.out.println("Function in progress...");
    }

    @Override
    public String describe() {
        return "Show all transactions from special client.";
    }
}