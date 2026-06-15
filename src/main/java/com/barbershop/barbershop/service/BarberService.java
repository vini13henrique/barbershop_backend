package com.barbershop.barbershop.service;

import com.barbershop.barbershop.dto.BarberRequestDTO;
import com.barbershop.barbershop.entity.Barber;
import com.barbershop.barbershop.exception.BarberNotFoundException;
import com.barbershop.barbershop.exception.InvalidBarberDataException;
import com.barbershop.barbershop.repository.BarberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarberService {

    private final BarberRepository barberRepository;

    public BarberService(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }

    public List<Barber> findAll() {
        List<Barber> barbers = barberRepository.findAll();
        return barbers;
    }

    public Barber createBarber(BarberRequestDTO barber) {
        Barber barberEntity = new Barber();
        String name = barber.getName();
        String specialty = barber.getSpecialty();

        if (name == null || name.trim().isEmpty()) {
            throw new InvalidBarberDataException("Erro: nome não pode ser nulo ou vazio");
        }

        if (specialty == null || specialty.trim().isEmpty()) {
            throw new InvalidBarberDataException("Erro: especialidade não pode ser nulo ou vazio");
        }
        barberEntity.setName(name);
        barberEntity.setSpecialty(specialty);
        return barberRepository.save(barberEntity);
    }

    public Barber findById(Long id) {
        return barberRepository.findById(id).orElseThrow(()
                -> new BarberNotFoundException("Erro: barbeiro não encontrado com id: " + id));
    }

    public Barber updateBarber(Long id, BarberRequestDTO barberRequestDTO) {
        Barber barber = barberRepository.findById(id).orElseThrow(() -> new BarberNotFoundException("Erro: barbeiro não encontrado com id: " + id));

        String name = barberRequestDTO.getName();
        String specialty = barberRequestDTO.getSpecialty();

        if (name == null || name.trim().isEmpty()) {
            throw new InvalidBarberDataException("Erro: nome não pode ser vazio ou nulo");
        }

        if (specialty == null || specialty.trim().isEmpty()) {
            throw new InvalidBarberDataException("Erro: especialidade não pode ser vazio ou nulo");
        }

        barber.setName(name);
        barber.setSpecialty(specialty);
        return barberRepository.save(barber);
    }

    public void deleteBarber(Long id) {
        Barber barber = barberRepository.findById(id).orElseThrow(() -> new BarberNotFoundException("Erro: barbeiro não encontrado com id: " + id));
        barberRepository.delete(barber);
    }


}
