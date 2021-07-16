package com.intexsoft.project.commands.bank.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Account;
import com.intexsoft.project.entities.Bank;
import com.intexsoft.project.entities.Client;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;
import java.util.List;

public class DeleteClientAccountCommand implements Command {
    private final BankService bankService;
    private final ClientService clientService;
    private final ConsoleHelper consoleHelper;

    public DeleteClientAccountCommand(BankService bankService, ClientService clientService, ConsoleHelper consoleHelper) {
        this.bankService = bankService;
        this.clientService = clientService;
        this.consoleHelper = consoleHelper;
    }

    @Override
    public String name() {
        return "Delete Client Account";
    }

    @Override
    public void execute() {
        /*List<Bank> banks = bankService.getEntities();
        List<Client> clients = clientService.getEntities();

        if (!banks.isEmpty() && !clients.isEmpty()) {

            System.out.println("Choose bank to delete client account:");
            consoleHelper.show(banks);
            int bankToAdd = consoleHelper.validateIntToValue(banks.size());
            Bank bank = banks.get(bankToAdd - 1);

            System.out.println("Choose client to delete account:");
            consoleHelper.show(clients);
            int clientToAdd = consoleHelper.validateIntToValue(clients.size());
            Client client = clients.get(clientToAdd - 1);

            for (Account account : client.getAccounts()) {
                if (account.getBankName().equals(bank.getBankName())) {
                    client.getAccounts().remove(account);
                    List<Account> accounts = client.getAccounts();
                    client.setAccounts(accounts);
                }
            }

        } else {
            System.out.println("Bank or client list is empty.");
        }*/
        System.out.println("Option in progress...");
    }
}
