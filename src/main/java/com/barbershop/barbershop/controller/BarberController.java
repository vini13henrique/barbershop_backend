package com.barbershop.barbershop.controller;

import com.barbershop.barbershop.dto.BarberRequestDTO;
import com.barbershop.barbershop.entity.Barber;
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
    public ResponseEntity<List<Barber>> findAll() {
        List<Barber> barbers = barberService.findAll();
        return ResponseEntity.ok(barbers);
    }

    @PostMapping()
    public ResponseEntity<Barber> createBarber(@RequestBody BarberRequestDTO barberRequestDTO) {
        Barber barberNovo = barberService.createBarber(barberRequestDTO);
        return ResponseEntity.status(201).body(barberNovo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barber> findById(@PathVariable Long id) {
        Barber barber = barberService.findById(id);
        return ResponseEntity.ok(barber);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Barber> updateBarber(@PathVariable Long id, @RequestBody BarberRequestDTO barberRequestDTO) {
        Barber barber = barberService.updateBarber(id, barberRequestDTO);
        return ResponseEntity.ok(barber);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarber(@PathVariable Long id) {
        barberService.deleteBarber(id);
        return ResponseEntity.noContent().build();
    }
}
