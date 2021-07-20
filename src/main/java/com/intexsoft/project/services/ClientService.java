package com.intexsoft.project.services;

import com.intexsoft.project.entities.Client;
import com.intexsoft.project.entities.ClientType;
import com.intexsoft.project.repositories.ClientRepository;
import java.util.List;

public class ClientService extends AbstractService<Client, ClientRepository> {

    public ClientService(ClientRepository clientRepository) {
        super(clientRepository);
    }

    public void createClient(String name, ClientType clientType) {
        Client client = new Client(name, clientType);
        getT().createEntity(client);
    }

    public void updateClient(int choice, String name, ClientType clientType) {
        List<Client> clients = getEntities();
        Client clientToUpdate = clients.get(choice - 1);

        clientToUpdate.setName(name);
        clientToUpdate.setClientType(clientType);

        getT().updateEntity(choice, clientToUpdate);
    }
}