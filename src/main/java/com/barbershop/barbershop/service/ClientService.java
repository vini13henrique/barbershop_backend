package com.barbershop.barbershop.service;

import com.barbershop.barbershop.dto.ClientRequestDTO;
import com.barbershop.barbershop.dto.ClientResponseDTO;
import com.barbershop.barbershop.entity.Appointment;
import com.barbershop.barbershop.entity.Client;
import com.barbershop.barbershop.exception.ClientNotFoundException;
import com.barbershop.barbershop.exception.InvalidClientDataException;
import com.barbershop.barbershop.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientResponseDTO> findAll() {
        List<Client> clients = clientRepository.findAll();
        List<ClientResponseDTO> clientResponseDTOS = new ArrayList<>();

        for(Client client : clients){

            ClientResponseDTO dto = new ClientResponseDTO(client.getId(), client.getName(), client.getPhone());
            clientResponseDTOS.add(dto);
        }

        return clientResponseDTOS;
    }

    public ClientResponseDTO createClient(ClientRequestDTO client) {
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

        Client savedClient = clientRepository.save(clientEntity);

        ClientResponseDTO clientResponseDTO = new ClientResponseDTO(
                savedClient.getId(),
                savedClient.getName(),
                savedClient.getPhone()
        );

        return clientResponseDTO;

    }

    public ClientResponseDTO findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Erro: cliente não encontrado com id " + id));
        ClientResponseDTO clientResponseDTO = new ClientResponseDTO(client.getId(), client.getName(), client.getPhone());
        return clientResponseDTO;
    }

    public ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO) {
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

        Client atualizarCliente = clientRepository.save(client);

        ClientResponseDTO clientResponseDTO = new ClientResponseDTO(
                atualizarCliente.getId(),
                atualizarCliente.getName(),
                atualizarCliente.getPhone()
        );
        return clientResponseDTO;
    }

    ;

    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Erro: cliente não encontrado com id " + id));
        clientRepository.delete(client);
    }
}
