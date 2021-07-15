package com.intexsoft.project.entities;

public enum ClientType {
    LEGAL("Legal"), INDIVIDUAL("Individual");

    private final String type;

    ClientType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}