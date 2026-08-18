package com.barbershop.barbershop.service;

import com.barbershop.barbershop.dto.AppointmentRequestDTO;
import com.barbershop.barbershop.dto.AppointmentResponseDTO;
import com.barbershop.barbershop.entity.Appointment;
import com.barbershop.barbershop.entity.Barber;
import com.barbershop.barbershop.entity.Client;
import com.barbershop.barbershop.exception.AppointmentNotFoundException;
import com.barbershop.barbershop.exception.BarberNotFoundException;
import com.barbershop.barbershop.exception.ClientNotFoundException;
import com.barbershop.barbershop.exception.InvalidAppointmentDataException;
import com.barbershop.barbershop.repository.AppointmentRepository;
import com.barbershop.barbershop.repository.BarberRepository;
import com.barbershop.barbershop.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO appointmentRequestDTO) {
        LocalDateTime appointmentDate = appointmentRequestDTO.getAppointmentDate();
        Long barberId = appointmentRequestDTO.getBarberId();
        Long clientId = appointmentRequestDTO.getClientId();

        if (appointmentDate == null) {
            throw new InvalidAppointmentDataException("Data do agendamento é obrigatória.");
        }

        if (appointmentDate.isBefore(LocalDateTime.now())) {
            throw new InvalidAppointmentDataException("O agendamento não pode ser realizado em uma data passada.");
        }

        if (barberId == null) {
            throw new InvalidAppointmentDataException("ID do barbeiro é obrigatório.");
        }

        Barber barber = barberRepository.findById(barberId)
                .orElseThrow(() -> new BarberNotFoundException("Barbeiro não encontrado com ID: " + barberId));

        if (clientId == null) {
            throw new InvalidAppointmentDataException("ID do cliente é obrigatório.");
        }

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException("Cliente não encontrado com ID: " + clientId));

        boolean horarioOcupadoBarber = appointmentRepository.existsByBarberIdAndAppointmentDate(barberId, appointmentDate);
        boolean horarioOcupadoClient = appointmentRepository.existsByClientIdAndAppointmentDate(clientId, appointmentDate);

        if (horarioOcupadoBarber) {
            throw new InvalidAppointmentDataException("Barbeiro já possui agendamento nesse horário.");
        }

        if (horarioOcupadoClient) {
            throw new InvalidAppointmentDataException("Cliente já possui agendamento nesse horário.");
        }

        Appointment appointment = new Appointment(appointmentDate, barber, client);
        Appointment savedAppointment = appointmentRepository.save(appointment);

        AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO(
                savedAppointment.getId(),
                savedAppointment.getAppointmentDate(),
                savedAppointment.getBarber().getId(),
                savedAppointment.getBarber().getName(),
                savedAppointment.getClient().getId(),
                savedAppointment.getClient().getName()
        );

        return appointmentResponseDTO;
    }

    public AppointmentResponseDTO findById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Agendamento não encontrado com ID: " + id));

        AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO(
                appointment.getId(),
                appointment.getAppointmentDate(),
                appointment.getBarber().getId(),
                appointment.getBarber().getName(),
                appointment.getClient().getId(),
                appointment.getClient().getName()
        );

        return appointmentResponseDTO;
    }

    public List<AppointmentResponseDTO> getAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        List<AppointmentResponseDTO> appointmentResponseDTOS = new ArrayList<>();

        for (Appointment appointment : appointments) {
            AppointmentResponseDTO dto = new AppointmentResponseDTO(
                    appointment.getId(),
                    appointment.getAppointmentDate(),
                    appointment.getBarber().getId(),
                    appointment.getBarber().getName(),
                    appointment.getClient().getId(),
                    appointment.getClient().getName()
            );

            appointmentResponseDTOS.add(dto);
        }

        return appointmentResponseDTOS;
    }

    public AppointmentResponseDTO update(Long id, AppointmentRequestDTO appointmentRequestDTO) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Agendamento não encontrado com ID: " + id));

        LocalDateTime appointmentDate = appointmentRequestDTO.getAppointmentDate();
        Long barberId = appointmentRequestDTO.getBarberId();
        Long clientId = appointmentRequestDTO.getClientId();

        if (appointmentDate == null) {
            throw new InvalidAppointmentDataException("Data do agendamento é obrigatória.");
        }

        if (appointmentDate.isBefore(LocalDateTime.now())) {
            throw new InvalidAppointmentDataException("O agendamento não pode ser realizado em uma data passada.");
        }

        if (barberId == null) {
            throw new InvalidAppointmentDataException("ID do barbeiro é obrigatório.");
        }

        Barber barber = barberRepository.findById(barberId)
                .orElseThrow(() -> new BarberNotFoundException("Barbeiro não encontrado com ID: " + barberId));

        if (clientId == null) {
            throw new InvalidAppointmentDataException("ID do cliente é obrigatório.");
        }

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException("Cliente não encontrado com ID: " + clientId));

        boolean horarioOcupadoBarber = appointmentRepository.existsByBarberIdAndAppointmentDateAndIdNot(barberId, appointmentDate, id);
        boolean horarioOcupadoClient = appointmentRepository.existsByClientIdAndAppointmentDateAndIdNot(clientId, appointmentDate, id);

        if (horarioOcupadoBarber) {
            throw new InvalidAppointmentDataException("Barbeiro já possui agendamento nesse horário.");
        }

        if (horarioOcupadoClient) {
            throw new InvalidAppointmentDataException("Cliente já possui agendamento nesse horário.");
        }

        appointment.setAppointmentDate(appointmentDate);
        appointment.setBarber(barber);
        appointment.setClient(client);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO(
                savedAppointment.getId(),
                savedAppointment.getAppointmentDate(),
                savedAppointment.getBarber().getId(),
                savedAppointment.getBarber().getName(),
                savedAppointment.getClient().getId(),
                savedAppointment.getClient().getName()
        );

        return appointmentResponseDTO;
    }

    public void delete(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Agendamento não encontrado com ID: " + id));

        appointmentRepository.delete(appointment);
    }
}