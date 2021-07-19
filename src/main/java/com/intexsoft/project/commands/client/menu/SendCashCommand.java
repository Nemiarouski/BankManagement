package com.intexsoft.project.commands.client.menu;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.*;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.CommandHelper;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class SendCashCommand implements Command {
    private final CommandHelper commandHelper;
    private final ClientService clientService;
    private final BankService bankService;

    public SendCashCommand(CommandHelper commandHelper, ClientService clientService, BankService bankService) {
        this.commandHelper = commandHelper;
        this.clientService = clientService;
        this.bankService = bankService;
    }

    private void chooseSendingType(Client sender, Account senderAccount, Account receiverAccount, BigDecimal money) {
        if (senderAccount.getBankName().equals(receiverAccount.getBankName())) {
            sendCashInSameBank(senderAccount, receiverAccount, money);
        } else {
            sendCashInDifferentBanks(sender, senderAccount, receiverAccount, money);
        }
    }

    private void converter(Account senderAccount, Account receiverAccount, BigDecimal money) {
        CurrencyType senderCurrency = senderAccount.getCurrencyType();
        CurrencyType receiverCurrency = receiverAccount.getCurrencyType();

        BigDecimal receiverMoney = BigDecimal.valueOf((senderCurrency.getCurrency() * money.doubleValue()) / receiverCurrency.getCurrency());
        receiverAccount.addCash(receiverMoney);
    }

    private void sendCashInSameBank(Account senderAccount, Account receiverAccount, BigDecimal money) {
        converter(senderAccount, receiverAccount, money);
        senderAccount.deleteCash(money);
    }

    private BigDecimal getPercent(Client sender, Account senderAccount) {
        BigDecimal percent = BigDecimal.valueOf(0);

        ClientType senderType = sender.getClientType();

        List<Bank> banks = bankService.getT().getEntities();
        Optional<Bank> optionalBank = banks.stream()
                .filter(b -> b.getBankName().equals(senderAccount.getBankName()))
                .findFirst();

        if (optionalBank.isPresent()) {
            Bank senderBank = optionalBank.get();
            if (senderType.equals(ClientType.INDIVIDUAL)) {
                percent = BigDecimal.valueOf(senderBank.getIndividualRate() / 100);
            } else {
                percent = BigDecimal.valueOf(senderBank.getLegalRate() / 100);
            }
        }
        return percent;
    }

    private void sendCashInDifferentBanks(Client sender, Account senderAccount, Account receiverAccount, BigDecimal money) {
        converter(senderAccount, receiverAccount, money);
        money = money.add(money.multiply(getPercent(sender, senderAccount)));
        senderAccount.deleteCash(money);
    }

    @Override
    public String getName() {
        return "Send Cash";
    }

    @Override
    public void execute() {
        List<Client> clients = clientService.getEntities();
        if (clients.size() > 0) {

            System.out.println("Choose client to send money:");
            Client sender = commandHelper.getEntity(clients);

            List<Account> senderAccounts = sender.getAccounts();
            Account senderAccount = commandHelper.getEntity(senderAccounts);

            System.out.println("How much money to send?");
            BigDecimal money = BigDecimal.valueOf(commandHelper.validateDouble());

            if (money.add(money.multiply(getPercent(sender, senderAccount))).compareTo(senderAccount.getCash()) <= 0) {
                System.out.println("Choose client to receive money:");
                Client receiver = commandHelper.getEntity(clients);

                List<Account> receiverAccounts = receiver.getAccounts();
                Account receiverAccount = commandHelper.getEntity(receiverAccounts);

                chooseSendingType(sender, senderAccount, receiverAccount, money);
            } else {
                System.out.println("Isn't enough money to send.");
            }
        } else {
            System.out.println("Need more client to send money.");
        }
    }
}