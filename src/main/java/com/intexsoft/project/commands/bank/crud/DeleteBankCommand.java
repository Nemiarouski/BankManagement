package com.intexsoft.project.commands.bank.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Bank;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.utils.CommandHelper;
import java.util.List;

public class DeleteBankCommand implements Command {
    private final CommandHelper commandHelper;
    private final BankService bankService;

    public DeleteBankCommand(CommandHelper commandHelper, BankService bankService) {
        this.commandHelper = commandHelper;
        this.bankService = bankService;
    }

    private Bank getBankToDelete(List<Bank> banks) {
        int choice = commandHelper.validateIntToValue(banks.size());
        return banks.get(choice - 1);
    }

    @Override
    public String getName() {
        return "Delete Bank";
    }

    @Override
    public void execute() {
        List<Bank> banks = bankService.getEntities();
        commandHelper.show(banks);

        System.out.println("Input bank to delete");
        Bank bank = getBankToDelete(banks);

        bankService.deleteEntity(bank);
    }

    @Override
    public String describe() {
        return "Delete bank from bank system.";
    }
}