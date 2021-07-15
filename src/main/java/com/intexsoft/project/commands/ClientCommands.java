package com.intexsoft.project.commands;

import java.util.List;

public class ClientCommands implements Command {
    private List<Command> clientCommands;

    public ClientCommands(List<Command> clientCommands) {
        this.clientCommands = clientCommands;
    }

    @Override
    public String name() {
        return "Client Menu";
    }

    @Override
    public void execute() {

    }
}