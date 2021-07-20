package com.intexsoft.project.commands;

import com.intexsoft.project.commands.bank.crud.*;
import com.intexsoft.project.commands.bank.menu.AddClientToBankCommand;
import com.intexsoft.project.commands.bank.menu.BankMenuCommand;
import com.intexsoft.project.commands.bank.menu.DeleteClientAccountCommand;
import com.intexsoft.project.commands.bank.menu.DownloadDatabaseCommand;
import com.intexsoft.project.commands.client.crud.*;
import com.intexsoft.project.commands.client.menu.*;
import com.intexsoft.project.services.BankService;
import com.intexsoft.project.services.ClientService;
import com.intexsoft.project.utils.CommandHelper;
import java.util.ArrayList;
import java.util.List;

public class HelpCommand implements Command {
    private final List<Command> bankCrudCommands = new ArrayList<>();
    private final List<Command> bankMenuCommands = new ArrayList<>();
    private final List<Command> clientCrudCommands = new ArrayList<>();
    private final List<Command> clientMenuCommands = new ArrayList<>();

    private final CommandHelper commandHelper;
    private final ClientService clientService;
    private final BankService bankService;
    private final ExitCommand exitCommand = new ExitCommand();

    public HelpCommand(CommandHelper commandHelper, ClientService clientService, BankService bankService) {
        this.commandHelper = commandHelper;
        this.clientService = clientService;
        this.bankService = bankService;
    }

    private void addCommand(List<Command> commands, Command command) {
        commands.add(command);
    }

    private void fillBankCrud() {
        addCommand(bankCrudCommands, new BankCrudCommand(commandHelper, bankService));
        addCommand(bankCrudCommands, new CreateBankCommand(commandHelper, bankService));
        addCommand(bankCrudCommands, new DeleteBankCommand(commandHelper, bankService));
        addCommand(bankCrudCommands, new UpdateBankCommand(commandHelper, bankService));
        addCommand(bankCrudCommands, new SaveBankCommand(bankService));
        addCommand(bankCrudCommands, new DownloadBankCommand(bankService));
        addCommand(bankCrudCommands, new ShowBanksCommand(commandHelper, bankService));
    }

    private void fillBankMenu() {
        addCommand(bankMenuCommands, new BankMenuCommand(commandHelper, clientService, bankService));
        addCommand(bankMenuCommands, new AddClientToBankCommand(bankService, clientService, commandHelper));
        addCommand(bankMenuCommands, new DeleteClientAccountCommand(bankService, clientService, commandHelper));
        addCommand(bankMenuCommands, new DownloadDatabaseCommand(clientService, bankService));
    }

    private void fillClientCrud() {
        addCommand(clientCrudCommands, new ClientCrudCommand(commandHelper, clientService));
        addCommand(clientCrudCommands, new CreateClientCommand(commandHelper, clientService));
        addCommand(clientCrudCommands, new DeleteClientCommand(commandHelper, clientService));
        addCommand(clientCrudCommands, new UpdateClientCommand(commandHelper, clientService));
        addCommand(clientCrudCommands, new SaveClientCommand(clientService));
        addCommand(clientCrudCommands, new DownloadClientCommand(clientService));
        addCommand(clientCrudCommands, new ShowClientsCommand(commandHelper, clientService));
    }

    private void fillClientMenu() {
        addCommand(clientMenuCommands, new ClientMenuCommand(commandHelper, bankService, clientService));
        addCommand(clientMenuCommands, new DepositCashCommand(clientService, commandHelper));
        addCommand(clientMenuCommands, new WithdrawCashCommand(clientService, commandHelper));
        addCommand(clientMenuCommands, new SendCashCommand(commandHelper, clientService, bankService));
        addCommand(clientMenuCommands, new ClientAccountsCommand(commandHelper, clientService));
        addCommand(clientMenuCommands, new ClientTransactionsCommand(commandHelper, clientService));
    }

    private void showAllCommands(List<Command> commands) {
        for (Command command : commands) {
            System.out.println("[" + command.getName() + "]");
            System.out.println("  - " + command.describe());
        }
    }

    @Override
    public String getName() {
        return "Help";
    }

    @Override
    public void execute() {
        fillBankCrud();
        fillBankMenu();
        fillClientCrud();
        fillClientMenu();
        showAllCommands(bankCrudCommands);
        System.out.println();
        showAllCommands(bankMenuCommands);
        System.out.println();
        showAllCommands(clientCrudCommands);
        System.out.println();
        showAllCommands(clientMenuCommands);
        System.out.println();
        System.out.println("[" + exitCommand.getName() + "]");
        System.out.println("  - " + exitCommand.describe());
        System.out.println();
    }

    @Override
    public String describe() {
        return "Show all commands with description.";
    }
}