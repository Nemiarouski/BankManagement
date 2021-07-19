package com.intexsoft.project.manager;

import com.intexsoft.project.commands.Command;

public class Manager {
    public void work(Command command) {
        command.getName();
        command.execute();
    }
}