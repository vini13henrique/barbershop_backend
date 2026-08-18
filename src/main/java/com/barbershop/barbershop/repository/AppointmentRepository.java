package com.barbershop.barbershop.repository;

import com.barbershop.barbershop.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    //Verifica conflito de barbeiro ao criar.
    boolean existsByBarberIdAndAppointmentDate(
            Long barberId,
            LocalDateTime appointmentDate);

    boolean existsByClientIdAndAppointmentDate(
            Long clientId,
            LocalDateTime appointmentDate);

    //Verifica conflito de barbeiro ao editar, ignorando o próprio agendamento.
    boolean existsByBarberIdAndAppointmentDateAndIdNot(
            Long barberId,
            LocalDateTime appointmentDate,
            Long appointmentId);

    boolean existsByClientIdAndAppointmentDateAndIdNot(
            Long clientId,
            LocalDateTime appointmentDate,
            Long appointmentId);
}
