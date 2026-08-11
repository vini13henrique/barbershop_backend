package com.barbershop.barbershop.controller;

import com.barbershop.barbershop.dto.ClientRequestDTO;
import com.barbershop.barbershop.dto.ClientResponseDTO;
import com.barbershop.barbershop.service.ClientService;
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
    public ResponseEntity<List<ClientResponseDTO>> findAll() {
        List<ClientResponseDTO> clientsDto = clientService.findAll();
        return ResponseEntity.ok(clientsDto);
    }

    @PostMapping()
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientRequestDTO clientRequestDTO) {
        ClientResponseDTO clientResponseDTO = clientService.createClient(clientRequestDTO);
        return ResponseEntity.status(201).body(clientResponseDTO);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> findById(@PathVariable Long id) {
        ClientResponseDTO clientResponseDTO = clientService.findById(id);
        return ResponseEntity.ok(clientResponseDTO);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> updateClient(@PathVariable Long id, @RequestBody ClientRequestDTO clientRequestDTO) {
        ClientResponseDTO clientResponseDTO = clientService.updateClient(id, clientRequestDTO);
        return ResponseEntity.ok(clientResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
