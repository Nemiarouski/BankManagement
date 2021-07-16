package com.intexsoft.project.commands.client.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Client;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.ConsoleHelper;

import java.math.BigDecimal;
import java.util.List;

public class SendCashCommand implements Command {
    private final ConsoleHelper consoleHelper;
    private final ClientService clientService;
    private final BankService bankService;

    public SendCashCommand(ConsoleHelper consoleHelper, ClientService clientService, BankService bankService) {
        this.consoleHelper = consoleHelper;
        this.clientService = clientService;
        this.bankService = bankService;
    }

    private Client getClient(List<Client> clients) {
        consoleHelper.show(clients);
        int choice = consoleHelper.validateIntToValue(clients.size());
        return clients.get(choice - 1);
    }

    private void send(Client sender, Client receiver, BigDecimal money) {
        if (!sender.getAccounts().isEmpty() && !receiver.getAccounts().isEmpty()) {
            BigDecimal compare = new BigDecimal("0");
            if (sender.getAccounts().stream().findAny().get().getCash().compareTo(compare) > 0)
            sender.getAccounts().stream().findAny().get().deleteCash(money);
            receiver.getAccounts().stream().findAny().get().addCash(money);
        } else {
            System.out.println("Not enough money to send.");
        }
    }

    @Override
    public String name() {
        return "Send Cash";
    }

    @Override
    public void execute() {
        List<Client> clients = clientService.getEntities();
        if (clients.size() > 1) {

            System.out.println("Choose client to send money:");
            Client sender = getClient(clients);

            System.out.println("Choose client to receive money:");
            Client receiver = getClient(clients);

            System.out.println("How much money to send?");
            consoleHelper.show(sender.getAccounts());
            BigDecimal money = BigDecimal.valueOf(consoleHelper.validateDouble());

            send(sender, receiver, money);
        } else {
            System.out.println("Client list is empty.");
        }
    }
}