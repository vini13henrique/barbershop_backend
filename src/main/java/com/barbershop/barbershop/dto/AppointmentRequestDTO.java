package com.barbershop.barbershop.dto;


import java.time.LocalDateTime;

public class AppointmentRequestDTO {

    private LocalDateTime appointmentDate;
    private Long barberId;
    private Long clientId;

    public AppointmentRequestDTO() {

    }

    public AppointmentRequestDTO(LocalDateTime appointmentDate, Long barberId, Long clientId) {
        this.appointmentDate = appointmentDate;
        this.barberId = barberId;
        this.clientId = clientId;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Long getBarberId() {
        return barberId;
    }

    public void setBarberId(Long barberId) {
        this.barberId = barberId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
