package com.intexsoft.project.commands;

public class ExitCommand implements Command {
    @Override
    public String getName() {
        return "Exit";
    }

    @Override
    public void execute() {}

    @Override
    public String describe() {
        return "This command close bank management application.";
    }
}