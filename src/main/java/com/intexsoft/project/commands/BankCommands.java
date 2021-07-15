package com.intexsoft.project.commands;

import java.util.ArrayList;
import java.util.List;

public class BankCommands implements Command {
    private List<Command> bankCommands = new ArrayList<>();

    @Override
    public String name() {
        return "Bank Menu";
    }

    @Override
    public void execute() {

    }
}