package com.intexsoft.project.commands.client.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.commands.bank.CreateBankCommand;
import com.intexsoft.project.commands.client.crud.CreateClientCommand;
import com.intexsoft.project.entities.Account;
import com.intexsoft.project.entities.Bank;
import com.intexsoft.project.entities.Client;
import com.intexsoft.project.entities.CurrencyType;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;
import java.util.List;

public class AddClientToBankCommand implements Command {
    private final BankService bankService;
    private final ClientService clientService;
    private final ConsoleHelper consoleHelper;
    private final CreateClientCommand createClientCommand;
    private final CreateBankCommand createBankCommand;

    public AddClientToBankCommand(BankService bankService, ClientService clientService, ConsoleHelper consoleHelper) {
        this.bankService = bankService;
        this.clientService = clientService;
        this.consoleHelper = consoleHelper;
        this.createClientCommand = new CreateClientCommand(consoleHelper, clientService);
        this.createBankCommand = new CreateBankCommand(consoleHelper, bankService);
    }

    @Override
    public String name() {
        return "Add Client To Bank";
    }

    @Override
    public void execute() {
        List<Bank> banks = bankService.getEntities();
        if (banks.isEmpty()) {
            System.out.println("Bank list is empty. Create new one.");
            createBankCommand.execute();
        }

        List<Client> clients = clientService.getEntities();
        if (clients.isEmpty()) {
            System.out.println("Client list is empty. Create new one.");
            createClientCommand.execute();
        }

        System.out.println("Choose bank to add client:");
        consoleHelper.show(banks);
        int bankToAdd = consoleHelper.validateIntToValue(banks.size());
        Bank bank = banks.get(bankToAdd - 1);

        System.out.println("Choose client to add:");
        consoleHelper.show(clients);
        int clientToAdd = consoleHelper.validateIntToValue(clients.size());
        Client client = clients.get(clientToAdd - 1);

        System.out.println("Create account.");
        List<CurrencyType> currencyTypes = List.of(CurrencyType.values());
        System.out.println("Choose currency:");
        consoleHelper.show(currencyTypes);
        int currency = consoleHelper.validateIntToValue(currencyTypes.size());
        CurrencyType currencyType = currencyTypes.get(currency - 1);
        Account account = new Account(bank.getBankName(), currencyType);

        client.addAccount(account);
        bank.addClientToMap(account, client);
    }
}