package com.intexsoft.project.services;

import com.intexsoft.project.entities.Client;
import com.intexsoft.project.entities.ClientType;
import com.intexsoft.project.repositories.ClientRepository;

import java.io.IOException;
import java.util.List;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void createClient(String name, ClientType clientType) {
        clientRepository.createEntity(name, clientType);
    }

    public void readClient() {

    }

    public void updateClient() {

    }

    public void deleteClient(Client client) {
        clientRepository.deleteEntity(client);
    }

    public List<Client> getClients() {
        return clientRepository.getEntities();
    }

    public void save() {
        try {
            clientRepository.saveEntities();
        } catch (IOException e) {
            System.err.println("We have some problems with: " + e);
        }
    }

    public void download() {
        try {
            clientRepository.downloadEntities();
        } catch (IOException e) {
            System.err.println("We have some problems with: " + e);
        }
    }
}