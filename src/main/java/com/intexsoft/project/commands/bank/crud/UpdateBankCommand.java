package com.intexsoft.project.commands.bank.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Bank;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.utils.ConsoleHelper;

import java.util.List;

public class UpdateBankCommand implements Command {
    private final ConsoleHelper consoleHelper;
    private final BankService bankService;

    public UpdateBankCommand(ConsoleHelper consoleHelper, BankService bankService) {
        this.consoleHelper = consoleHelper;
        this.bankService = bankService;
    }

    private void show(List<Bank> banks) {
        for (int i = 0; i < banks.size(); i++) {
            System.out.println((i + 1) + ") " + banks.get(i));
        }
    }

    @Override
    public String name() {
        return "Update Bank";
    }

    @Override
    public void execute() {
        List<Bank> banks = bankService.getBanks();
        show(banks);

        System.out.println("Choose bank to update:");
        int choice = consoleHelper.validateIntToValue(banks.size());

        System.out.println("Input bank name:");
        String bankName = consoleHelper.read();

        System.out.println("Input legal rate:");
        double legalRate = consoleHelper.validateDouble();

        System.out.println("Input individual rate:");
        double individualRate = consoleHelper.validateDouble();

        bankService.updateBank(choice, bankName, legalRate, individualRate);
    }
}