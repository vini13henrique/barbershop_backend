package com.barbershop.barbershop.service;

import com.barbershop.barbershop.entity.Client;
import com.barbershop.barbershop.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }
}
