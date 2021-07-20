package com.intexsoft.project.commands.client.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Account;
import com.intexsoft.project.entities.Client;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.CommandHelper;
import java.math.BigDecimal;
import java.util.List;

public class DepositCashCommand implements Command {
    private final ClientService clientService;
    private final CommandHelper commandHelper;

    public DepositCashCommand(ClientService clientService, CommandHelper commandHelper) {
        this.clientService = clientService;
        this.commandHelper = commandHelper;
    }

    @Override
    public String getName() {
        return "Deposit Cash";
    }

    @Override
    public void execute() {
        Account account;
        List<Client> clients = clientService.getEntities();

        System.out.println("Choose client to deposit money:");
        Client client = commandHelper.getEntity(clients);

        if (!client.getAccounts().isEmpty()) {
            System.out.println("Choose account:");

            List<Account> accounts = client.getAccounts();
            account = commandHelper.getEntity(accounts);

            System.out.println("How much money to deposit?");
            BigDecimal money = BigDecimal.valueOf(commandHelper.validateInt());

            account.addCash(money);
        } else {
            System.out.println("Create account before deposit money");
        }
    }

    @Override
    public String describe() {
        return "Command help client to deposit his money to account.";
    }
}