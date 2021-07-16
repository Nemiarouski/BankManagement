package com.intexsoft.project.commands.bank;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.utils.ConsoleHelper;
import java.util.List;

public class BankCrudCommands implements Command {
    private final ConsoleHelper consoleHelper;
    private final List<Command> bankCommands;

    public BankCrudCommands(ConsoleHelper consoleHelper, BankService bankService) {
        this.consoleHelper = consoleHelper;
        bankCommands = List.of(
                new CreateBankCommand(consoleHelper, bankService),
                new DeleteBankCommand(consoleHelper, bankService),
                new UpdateBankCommand(consoleHelper, bankService),
                new ShowBanksCommand(consoleHelper, bankService),
                new SaveBankCommand(bankService),
                new DownloadBankCommand(bankService)
        );
    }

    private void showCommands() {
        for (int i = 0; i < bankCommands.size(); i++) {
            System.out.println((i + 1) + ") " + bankCommands.get(i).name());
        }
    }

    private void chooseCommand() {
        int choice = consoleHelper.validateIntToValue(bankCommands.size());
        bankCommands.get(choice - 1).execute();
    }

    @Override
    public String name() {
        return "Bank Menu";
    }

    @Override
    public void execute() {
        showCommands();
        chooseCommand();
    }
}