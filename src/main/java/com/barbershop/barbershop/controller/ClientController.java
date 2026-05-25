package com.barbershop.barbershop.controller;

import com.barbershop.barbershop.dto.ClientRequestDTO;
import com.barbershop.barbershop.entity.Client;
import com.barbershop.barbershop.service.ClientService;
import jakarta.persistence.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clients = clientService.findAll();
        return ResponseEntity.ok(clients);
    }

    @PostMapping()
    public ResponseEntity<Client> createClient(@RequestBody ClientRequestDTO clientRequestDTO) {
        Client clientNovo = clientService.createClient(clientRequestDTO);
        return ResponseEntity.status(201).body(clientNovo);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        Client client = clientService.findById(id);
        return ResponseEntity.ok(client);

    }
}
