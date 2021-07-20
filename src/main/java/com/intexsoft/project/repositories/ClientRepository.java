package com.intexsoft.project.repositories;

import com.intexsoft.project.entities.Client;

public class ClientRepository extends AbstractRepository<Client> {
    @Override
    protected String filepath() {
        return "clients.json";
    }
}