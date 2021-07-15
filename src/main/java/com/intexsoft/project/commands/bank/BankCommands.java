package com.intexsoft.project.commands.bank;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;
import java.util.List;

public class BankCommands implements Command {
    private List<Command> bankCommands;

    public BankCommands(BankService bankService) {
        bankCommands = List.of(
                new CreateBankCommand(bankService),
                new DeleteBankCommand(bankService),
                new DownloadBankCommand(bankService),
                new SaveBankCommand(bankService),
                new UpdateBankCommand(bankService));
    }

    @Override
    public String name() {
        return "Bank Menu";
    }

    @Override
    public void execute() {

    }
}