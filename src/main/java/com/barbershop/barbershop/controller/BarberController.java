package com.barbershop.barbershop.controller;

import com.barbershop.barbershop.entity.Barber;
import com.barbershop.barbershop.service.BarberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
