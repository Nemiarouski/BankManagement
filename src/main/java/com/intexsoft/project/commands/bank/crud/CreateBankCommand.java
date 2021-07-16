package com.intexsoft.project.commands.bank.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.utils.ConsoleHelper;

public class CreateBankCommand implements Command {
    private final ConsoleHelper consoleHelper;
    private final BankService bankService;

    public CreateBankCommand(ConsoleHelper consoleHelper, BankService bankService) {
        this.consoleHelper = consoleHelper;
        this.bankService = bankService;
    }

    @Override
    public String name() {
        return "Create Bank";
    }

    @Override
    public void execute() {
        System.out.println("Input bank name:");
        String bankName = consoleHelper.read();

        System.out.println("Input legal rate:");
        double legalRate = consoleHelper.validateDouble();

        System.out.println("Input individual rate:");
        double individualRate = consoleHelper.validateDouble();

        bankService.createBank(bankName, legalRate, individualRate);
    }
}