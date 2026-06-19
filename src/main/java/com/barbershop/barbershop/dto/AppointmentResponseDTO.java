package com.barbershop.barbershop.dto;


import java.time.LocalDateTime;

public class AppointmentResponseDTO {

    private Long id;
    private LocalDateTime appointmentDate;
    private Long barberId;
    private String barberName;
    private Long clientId;
    private String clientName;

    public AppointmentResponseDTO(Long id, LocalDateTime appointmentDate, Long barberId, String barberName, Long clientId, String clientName) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.barberId = barberId;
        this.barberName = barberName;
        this.clientId = clientId;
        this.clientName = clientName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getBarberName() {
        return barberName;
    }

    public void setBarberName(String barberName) {
        this.barberName = barberName;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
