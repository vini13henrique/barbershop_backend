package com.barbershop.barbershop.repository;

import com.barbershop.barbershop.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

  boolean  existsByBarberIdAndAppointmentDate(Long barbedId, LocalDateTime appointmentDate);

  boolean existsByClientIdAndAppointmentDate(Long clientId, LocalDateTime appointmentDate);

  boolean  existsByBarberIdAndAppointmentDateAndIdNot(Long barberId  , LocalDateTime appointmentDate, Long appointmentId);

  boolean existsByClientIdAndAppointmentDateAndIdNot(Long clientId, LocalDateTime appointmentDate, Long appointmentId);
}
