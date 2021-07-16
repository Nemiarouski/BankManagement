package com.intexsoft.project.commands.client.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Account;
import com.intexsoft.project.entities.Client;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;
import java.math.BigDecimal;
import java.util.List;

public class DepositCashCommand implements Command {
    private final BankService bankService;
    private final ClientService clientService;
    private final ConsoleHelper consoleHelper;

    public DepositCashCommand(BankService bankService, ClientService clientService, ConsoleHelper consoleHelper) {
        this.bankService = bankService;
        this.clientService = clientService;
        this.consoleHelper = consoleHelper;
    }

    @Override
    public String name() {
        return "Deposit Cash";
    }

    @Override
    public void execute() {
        Account account;
        List<Client> clients = clientService.getEntities();
        consoleHelper.show(clients);

        System.out.println("Choose client to deposit money:");
        int choice = consoleHelper.validateIntToValue(clients.size());
        Client client = clients.get(choice - 1);

        if (!client.getAccounts().isEmpty()) {
            System.out.println("Choose account:");
            consoleHelper.show(client.getAccounts());
            int accountToDeposit = consoleHelper.validateIntToValue(client.getAccounts().size());
            account = client.getAccounts().get(accountToDeposit - 1);
            System.out.println("How much money to deposit?");
            BigDecimal money = BigDecimal.valueOf(consoleHelper.validateInt());
            account.addCash(money);
        } else {
            System.out.println("Create account before deposit money");
        }
    }
}