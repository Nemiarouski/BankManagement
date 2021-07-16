package com.intexsoft.project.commands.bank.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.entities.Bank;
import com.intexsoft.project.services.BankService;
import java.util.List;

public class ShowBanksCommand implements Command {
    private final BankService bankService;

    public ShowBanksCommand(BankService bankService) {
        this.bankService = bankService;
    }

    private void show(List<Bank> banks) {
        for (int i = 0; i < banks.size(); i++) {
            System.out.println((i + 1) + ") " + banks.get(i));
        }
    }

    @Override
    public String name() {
        return "Show Banks";
    }

    @Override
    public void execute() {
        List<Bank> banks = bankService.getEntities();
        show(banks);
    }
}