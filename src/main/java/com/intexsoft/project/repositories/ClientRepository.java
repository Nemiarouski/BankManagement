package com.intexsoft.project.repositories;

import com.intexsoft.project.entities.Client;
import com.intexsoft.project.entities.ClientType;
import java.util.List;

public class ClientRepository extends AbstractRepository<Client> {

    @Override
    protected String filepath() {
        return "clients.json";
    }

    public void createEntity(String name, ClientType clientType) {
        Client client = new Client(name, clientType);
        addEntity(client);
    }

    public void updateEntity(int choice, String name, ClientType clientType) {
        List<Client> clients = getEntities();
        Client clientToUpdate = clients.get(choice - 1);
        clientToUpdate.setName(name);
        clientToUpdate.setClientType(clientType);
    }
}