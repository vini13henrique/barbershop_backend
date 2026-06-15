package com.barbershop.barbershop.service;

import com.barbershop.barbershop.dto.AppointmentRequestDTO;
import com.barbershop.barbershop.entity.Appointment;
import com.barbershop.barbershop.entity.Barber;
import com.barbershop.barbershop.entity.Client;
import com.barbershop.barbershop.exception.BarberNotFoundException;
import com.barbershop.barbershop.exception.ClientNotFoundException;
import com.barbershop.barbershop.exception.InvalidAppointmentDataException;
import com.barbershop.barbershop.repository.AppointmentRepository;
import com.barbershop.barbershop.repository.BarberRepository;
import com.barbershop.barbershop.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final BarberRepository barberRepository;
    private final ClientRepository clientRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, BarberRepository barberRepository, ClientRepository clientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.barberRepository = barberRepository;
        this.clientRepository = clientRepository;
    }

    public Appointment createAppointment(AppointmentRequestDTO appointmentRequestDTO) {
        LocalDateTime appointmentDate = appointmentRequestDTO.getAppointmentDate();
        Long barberId = appointmentRequestDTO.getBarberId();
        Long clientId = appointmentRequestDTO.getClientId();

        if (appointmentDate == null) {
            throw new InvalidAppointmentDataException("Erro: Data não pode ser nula ou está vazia");
        }

        if (appointmentDate.isBefore(LocalDateTime.now())) {
            throw new InvalidAppointmentDataException("Erro: Agendamento não pode ser realizado em uma data passada");
        }

        if (barberId == null) {
            throw new InvalidAppointmentDataException("Erro: Id não pode ser nulo ou está vazio");
        }
        Barber barber = barberRepository.findById(barberId).orElseThrow(() -> new BarberNotFoundException("Barbeiro com id  " + barberId + " Não existe"));

        if (clientId == null) {
            throw new InvalidAppointmentDataException("Erro: Id não pode ser nulo ou está vazio");
        }

        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException("Cliente com id " + clientId + " Não existe"));


        Appointment appointment = new Appointment(appointmentDate, barber, client);
        return appointmentRepository.save(appointment);
    }
}
