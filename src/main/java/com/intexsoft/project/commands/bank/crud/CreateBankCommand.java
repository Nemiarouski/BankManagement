package com.intexsoft.project.commands.bank.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.utils.CommandHelper;

public class CreateBankCommand implements Command {
    private final CommandHelper commandHelper;
    private final BankService bankService;

    public CreateBankCommand(CommandHelper commandHelper, BankService bankService) {
        this.commandHelper = commandHelper;
        this.bankService = bankService;
    }

    @Override
    public String getName() {
        return "Create Bank";
    }

    @Override
    public void execute() {
        System.out.println("Input bank name:");
        String bankName = commandHelper.read();

        System.out.println("Input legal rate:");
        double legalRate = commandHelper.validateDouble();

        System.out.println("Input individual rate:");
        double individualRate = commandHelper.validateDouble();

        bankService.createBank(bankName, legalRate, individualRate);
    }
}