package com.intexsoft.project.commands.client.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Account;
import com.intexsoft.project.entities.Client;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.CommandHelper;
import java.math.BigDecimal;
import java.util.List;

public class WithdrawCashCommand implements Command {
    private final ClientService clientService;
    private final CommandHelper commandHelper;

    public WithdrawCashCommand(ClientService clientService, CommandHelper commandHelper) {
        this.clientService = clientService;
        this.commandHelper = commandHelper;
    }

    @Override
    public String getName() {
        return "Withdraw Cash";
    }

    @Override
    public void execute() {
        Account account;
        List<Client> clients = clientService.getEntities();

        System.out.println("Choose client to withdraw money:");
        Client client = commandHelper.getEntity(clients);

        if (!client.getAccounts().isEmpty()) {
            System.out.println("Choose account:");

            List<Account> accounts = client.getAccounts();
            account = commandHelper.getEntity(accounts);

            System.out.println("How much money to withdraw?");
            BigDecimal withdrawMoney = BigDecimal.valueOf(commandHelper.validateInt());
            BigDecimal accountMoney = account.getCash();

            if (accountMoney.compareTo(withdrawMoney) >= 0) {
                account.deleteCash(withdrawMoney);
            } else {
                System.out.println("Isn't enough money.");
            }
        } else {
            System.out.println("Create account before deposit money.");
        }
    }
}