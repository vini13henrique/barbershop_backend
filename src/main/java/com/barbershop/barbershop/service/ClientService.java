package com.barbershop.barbershop.service;

import com.barbershop.barbershop.dto.ClientRequestDTO;
import com.barbershop.barbershop.entity.Client;
import com.barbershop.barbershop.exception.ClientNotFoundException;
import com.barbershop.barbershop.exception.InvalidClientDataException;
import com.barbershop.barbershop.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            throw new InvalidClientDataException("Erro: nome não pode ser nulo ou  está vazio");
        }

        //validaçao phone não pode ser nulo ou está vazio
        if (phone == null || phone.trim().isEmpty()) {
            throw new InvalidClientDataException("Erro: Número de telefone não poder ser nulo ou está vazio");
        }
        clientEntity.setName(nome);
        clientEntity.setPhone(phone);
        return clientRepository.save(clientEntity);

    }

    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(()
                -> new ClientNotFoundException("Erro: cliente não encontrado com id " + id));

    }

    public Client updateClient(Long id, ClientRequestDTO clientRequestDTO) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Erro: cliente não encontrado com id " + id));

        String name = clientRequestDTO.getName();
        String phone = clientRequestDTO.getPhone();

        if (name == null || name.trim().isEmpty()) {
            throw new InvalidClientDataException("Erro: nome não pode ser nulo ou  está vazio");
        }

        if (phone == null || phone.trim().isEmpty()) {
            throw new InvalidClientDataException("Erro: Número de telefone não poder ser nulo ou está vazio");
        }

        client.setName(name);
        client.setPhone(phone);
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Erro: cliente não encontrado com id " + id));
        clientRepository.delete(client);
    }
}
