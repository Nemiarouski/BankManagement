package com.intexsoft.project.commands.bank.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Bank;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.utils.CommandHelper;
import java.util.List;

public class UpdateBankCommand implements Command {
    private final CommandHelper commandHelper;
    private final BankService bankService;

    public UpdateBankCommand(CommandHelper commandHelper, BankService bankService) {
        this.commandHelper = commandHelper;
        this.bankService = bankService;
    }

    @Override
    public String getName() {
        return "Update Bank";
    }

    @Override
    public void execute() {
        List<Bank> banks = bankService.getEntities();
        commandHelper.show(banks);

        System.out.println("Choose bank to update:");
        int choice = commandHelper.validateIntToValue(banks.size());

        System.out.println("Input bank name:");
        String bankName = commandHelper.read();

        System.out.println("Input legal rate:");
        double legalRate = commandHelper.validateDouble();

        System.out.println("Input individual rate:");
        double individualRate = commandHelper.validateDouble();

        bankService.updateBank(choice, bankName, legalRate, individualRate);
    }

    @Override
    public String describe() {
        return "Update some bank information.";
    }
}