package com.barbershop.barbershop.service;

import com.barbershop.barbershop.dto.ClientRequestDTO;
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

    public Client createClient(ClientRequestDTO client) {
        Client clientEntity = new Client();
        String nome = client.getName();
        String phone = client.getPhone();

        //validaçap nome não pode ser nulo ou está vazio
        if (nome == null || nome.trim().isEmpty()) {
            throw new RuntimeException("Erro: nome não pode ser nulo ou  está vazio");
        }

        //validaçao phone não pode ser nulo ou está vazio
        if (phone == null || phone.trim().isEmpty()) {
            throw new RuntimeException("Erro: Número de telefone não poder ser nulo ou está vazio");
        }
        clientEntity.setName(client.getName());
        clientEntity.setPhone(client.getPhone());
        return clientRepository.save(clientEntity);

    }
}
