package com.intexsoft.project.commands.bank.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Account;
import com.intexsoft.project.entities.Bank;
import com.intexsoft.project.entities.Client;
import com.intexsoft.project.entities.CurrencyType;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.CommandHelper;
import java.util.List;

public class AddClientToBankCommand implements Command {
    private final BankService bankService;
    private final ClientService clientService;
    private final CommandHelper commandHelper;

    public AddClientToBankCommand(BankService bankService, ClientService clientService, CommandHelper commandHelper) {
        this.bankService = bankService;
        this.clientService = clientService;
        this.commandHelper = commandHelper;
    }

    @Override
    public String getName() {
        return "Add Client To Bank";
    }

    @Override
    public void execute() {
        List<Bank> banks = bankService.getEntities();
        List<Client> clients = clientService.getEntities();
        List<CurrencyType> currencyTypes = List.of(CurrencyType.values());

        if (!banks.isEmpty() && !clients.isEmpty()) {

            System.out.println("Choose bank to add client:");
            Bank bank = commandHelper.getEntity(banks);

            System.out.println("Choose client to add:");
            Client client = commandHelper.getEntity(clients);

            System.out.println("Create account. Choose currency");
            CurrencyType currencyType = commandHelper.getEntity(currencyTypes);

            Account account = new Account(bank.getBankName(), currencyType);

            client.addAccount(account);
            bank.addClientToMap(account, client);
        } else {
            System.out.println("Bank or client list is empty.");
        }
    }

    @Override
    public String describe() {
        return "Add client to special bank.";
    }
}