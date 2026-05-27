package com.barbershop.barbershop.service;

import com.barbershop.barbershop.entity.Barber;
import com.barbershop.barbershop.repository.BarberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarberService {

    private BarberRepository barberRepository;

    public BarberService(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }

    public List<Barber> findAll() {
        List<Barber> barbers = barberRepository.findAll();
        return barbers;
    }
}
