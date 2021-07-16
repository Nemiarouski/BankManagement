package com.intexsoft.project.services;

import com.intexsoft.project.entities.Client;
import com.intexsoft.project.entities.ClientType;
import com.intexsoft.project.repositories.ClientRepository;

public class ClientService extends AbstractService<Client, ClientRepository> {

    public ClientService(ClientRepository clientRepository) {
        super(clientRepository);
    }

    public void createClient(String name, ClientType clientType) {
        getT().createEntity(name, clientType);
    }

    public void updateClient(int choice, String name, ClientType clientType) {
        getT().updateEntity(choice, name, clientType);
    }
}