package com.barbershop.barbershop.service;

import com.barbershop.barbershop.dto.BarberRequestDTO;
import com.barbershop.barbershop.dto.BarberResponseDTO;
import com.barbershop.barbershop.entity.Barber;
import com.barbershop.barbershop.exception.BarberNotFoundException;
import com.barbershop.barbershop.exception.InvalidBarberDataException;
import com.barbershop.barbershop.repository.BarberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BarberService {

    private final BarberRepository barberRepository;

    public BarberService(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }

    public List<BarberResponseDTO> findAll() {
        List<Barber> barbers = barberRepository.findAll();
        List<BarberResponseDTO> barberResponseDTOS = new ArrayList<>();

        for (Barber barber : barbers) {

            BarberResponseDTO barberResponseDTO = new BarberResponseDTO(barber.getId(), barber.getName(), barber.getSpecialty());
            barberResponseDTOS.add(barberResponseDTO);

        }
        return barberResponseDTOS;
    }

    public BarberResponseDTO createBarber(BarberRequestDTO barber) {
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

        Barber savedBarber = barberRepository.save(barberEntity);
        BarberResponseDTO barberResponseDTO = new BarberResponseDTO(savedBarber.getId(), savedBarber.getName(), savedBarber.getSpecialty());
        return barberResponseDTO;
    }

    public BarberResponseDTO findById(Long id) {
        Barber barber = barberRepository.findById(id).orElseThrow(()
                -> new BarberNotFoundException("Erro: barbeiro não encontrado com id: " + id));
        BarberResponseDTO barberResponseDTO = new BarberResponseDTO(barber.getId(), barber.getName(), barber.getSpecialty());
        return barberResponseDTO;
    }

    public BarberResponseDTO updateBarber(Long id, BarberRequestDTO barberRequestDTO) {
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
        Barber savedBarber = barberRepository.save(barber);
        BarberResponseDTO barberResponseDTO = new BarberResponseDTO(savedBarber.getId(), savedBarber.getName(), savedBarber.getSpecialty());
        return barberResponseDTO;

    }

    public void deleteBarber(Long id) {
        Barber barber = barberRepository.findById(id).orElseThrow(() -> new BarberNotFoundException("Erro: barbeiro não encontrado com id: " + id));
        barberRepository.delete(barber);
    }


}
