package com.barbershop.barbershop.controller;

import com.barbershop.barbershop.dto.BarberRequestDTO;
import com.barbershop.barbershop.dto.BarberResponseDTO;
import com.barbershop.barbershop.service.BarberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/barbers")
public class BarberController {

    private BarberService barberService;

    public BarberController(BarberService barberService) {
        this.barberService = barberService;
    }

    @GetMapping()
    public ResponseEntity<List<BarberResponseDTO>> findAll() {
        List<BarberResponseDTO> barberResponseDTOS = barberService.findAll();
        return ResponseEntity.ok(barberResponseDTOS);
    }

    @PostMapping()
    public ResponseEntity<BarberResponseDTO> createBarber(@RequestBody BarberRequestDTO barberRequestDTO) {
        BarberResponseDTO barberResponseDTO = barberService.createBarber(barberRequestDTO);
        return ResponseEntity.status(201).body(barberResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarberResponseDTO> findById(@PathVariable Long id) {
        BarberResponseDTO barberResponseDTO = barberService.findById(id);
        return ResponseEntity.ok(barberResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BarberResponseDTO> updateBarber(@PathVariable Long id, @RequestBody BarberRequestDTO barberRequestDTO) {
        BarberResponseDTO barberResponseDTO = barberService.updateBarber(id, barberRequestDTO);
        return ResponseEntity.ok(barberResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarber(@PathVariable Long id) {
        barberService.deleteBarber(id);
        return ResponseEntity.noContent().build();
    }
}
