package com.intexsoft.project.commands.bank;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Bank;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.utils.ConsoleHelper;
import java.util.List;

public class ShowBanksCommand implements Command {
    private final ConsoleHelper consoleHelper;
    private final BankService bankService;

    public ShowBanksCommand(ConsoleHelper consoleHelper, BankService bankService) {
        this.consoleHelper = consoleHelper;
        this.bankService = bankService;
    }

    @Override
    public String name() {
        return "Show Banks";
    }

    @Override
    public void execute() {
        List<Bank> banks = bankService.getEntities();
        consoleHelper.show(banks);
    }
}