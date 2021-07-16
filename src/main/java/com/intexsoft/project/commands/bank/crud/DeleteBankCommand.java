package com.intexsoft.project.commands.bank.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Bank;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.utils.ConsoleHelper;
import java.util.List;

public class DeleteBankCommand implements Command {
    private final ConsoleHelper consoleHelper;
    private final BankService bankService;

    public DeleteBankCommand(ConsoleHelper consoleHelper, BankService bankService) {
        this.consoleHelper = consoleHelper;
        this.bankService = bankService;
    }

    private void showBanks(List<Bank> banks) {
        for (int i = 0; i < banks.size(); i++) {
            System.out.println((i + 1) + ") " + banks.get(i).toString());
        }
    }

    private Bank getBankToDelete(List<Bank> banks) {
        int choice = consoleHelper.validateIntToValue(banks.size());
        return banks.get(choice - 1);
    }

    @Override
    public String name() {
        return "Delete Bank";
    }

    @Override
    public void execute() {
        List<Bank> banks = bankService.getBanks();
        showBanks(banks);

        System.out.println("Input bank to delete");
        Bank bank = getBankToDelete(banks);

        bankService.deleteBank(bank);
    }
}