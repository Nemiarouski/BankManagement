package com.intexsoft.project.commands.bank.crud;

import com.intexsoft.project.commands.Command;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.utils.CommandHelper;
import java.util.List;

public class BankCrudCommand implements Command {
    private final CommandHelper commandHelper;
    private final List<Command> bankCommands;

    public BankCrudCommand(CommandHelper commandHelper, BankService bankService) {
        this.commandHelper = commandHelper;
        bankCommands = List.of(
                new CreateBankCommand(commandHelper, bankService),
                new DeleteBankCommand(commandHelper, bankService),
                new UpdateBankCommand(commandHelper, bankService),
                new ShowBanksCommand(commandHelper, bankService),
                new SaveBankCommand(bankService),
                new DownloadBankCommand(bankService));
    }

    private void showCommands() {
        for (int i = 0; i < bankCommands.size(); i++) {
            System.out.println((i + 1) + ") " + bankCommands.get(i).getName());
        }
    }

    private void chooseCommand() {
        int choice = commandHelper.validateIntToValue(bankCommands.size());
        bankCommands.get(choice - 1).execute();
    }

    @Override
    public String getName() {
        return "Bank Crud Menu";
    }

    @Override
    public void execute() {
        showCommands();
        chooseCommand();
    }
}