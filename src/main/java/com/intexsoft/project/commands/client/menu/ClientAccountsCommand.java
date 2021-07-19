package com.intexsoft.project.commands.client.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Account;
import com.intexsoft.project.entities.Client;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.CommandHelper;
import java.util.Comparator;
import java.util.List;

public class ClientAccountsCommand implements Command {
    private final CommandHelper commandHelper;
    private final ClientService clientService;

    public ClientAccountsCommand(CommandHelper commandHelper, ClientService clientService) {
        this.commandHelper = commandHelper;
        this.clientService = clientService;
    }

    @Override
    public String getName() {
        return "Client Accounts";
    }

    @Override
    public void execute() {
        List<Client> clients = clientService.getEntities();

        if (!clients.isEmpty()) {
            System.out.println("Choose client to show accounts:");
            Client client = commandHelper.getEntity(clients);

            List<Account> accounts = client.getAccounts();
            accounts.stream()
                    .sorted(Comparator.comparing(Account::getBankName))
                    .forEach(System.out::println);
        } else {
            System.out.println("Client list is empty. Create new one.");
        }
    }
}