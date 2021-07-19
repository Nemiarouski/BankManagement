package com.intexsoft.project.commands.bank.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Bank;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.utils.CommandHelper;
import java.util.List;

public class ShowBanksCommand implements Command {
    private final CommandHelper commandHelper;
    private final BankService bankService;

    public ShowBanksCommand(CommandHelper commandHelper, BankService bankService) {
        this.commandHelper = commandHelper;
        this.bankService = bankService;
    }

    @Override
    public String getName() {
        return "Show Banks";
    }

    @Override
    public void execute() {
        List<Bank> banks = bankService.getEntities();
        commandHelper.show(banks);
    }
}