package com.intexsoft.project.repositories;

import com.intexsoft.project.entities.Client;
import com.intexsoft.project.entities.ClientType;

public class ClientRepository extends AbstractRepository<Client> {

    @Override
    protected String filepath() {
        return "clients.json";
    }

    public void createEntity(String name, ClientType clientType) {
        Client client = new Client(name, clientType);
        addEntity(client);
    }
}