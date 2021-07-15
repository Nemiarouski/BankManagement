package com.intexsoft.project.commands.bank.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.utils.ConsoleHelper;
import java.util.List;

public class BankCRUDCommands implements Command {
    private final ConsoleHelper consoleHelper;
    private final List<Command> bankCommands;

    public BankCRUDCommands(ConsoleHelper consoleHelper, BankService bankService) {
        this.consoleHelper = consoleHelper;
        bankCommands = List.of(
                new CreateBankCommand(consoleHelper, bankService),
                new DeleteBankCommand(consoleHelper, bankService),
                new DownloadBankCommand(consoleHelper, bankService),
                new SaveBankCommand(consoleHelper, bankService),
                new UpdateBankCommand(consoleHelper, bankService));
    }

    @Override
    public String name() {
        return "Bank Menu";
    }

    @Override
    public void execute() {
        for (int i = 0; i < bankCommands.size(); i++) {
            System.out.println((i + 1) + ") " + bankCommands.get(i).name());
        }
        int choice = consoleHelper.validateIntToValue(bankCommands.size());
        bankCommands.get(choice - 1).execute();
    }
}