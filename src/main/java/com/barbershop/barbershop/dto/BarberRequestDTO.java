package com.barbershop.barbershop.dto;

public class BarberRequestDTO {

    private String name;
    private String specialty;

    public BarberRequestDTO() {

    }

    public BarberRequestDTO(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
