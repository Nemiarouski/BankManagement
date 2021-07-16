package com.intexsoft.project.commands.client.menu;

import com.intexsoft.project.commands.Command;

public class WithdrawCashCommand implements Command {
    @Override
    public String name() {
        return "Withdraw Cash";
    }

    @Override
    public void execute() {
        System.out.println("Option in progress...");
    }
}