package com.barbershop.barbershop.repository;

import com.barbershop.barbershop.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

  boolean  existsByBarberIdAndAppointmentDate(Long id, LocalDateTime appointmentDate);
}
