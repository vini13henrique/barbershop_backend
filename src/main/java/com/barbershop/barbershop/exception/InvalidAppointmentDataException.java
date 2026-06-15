package com.barbershop.barbershop.exception;

public class InvalidAppointmentDataException extends RuntimeException {
    public InvalidAppointmentDataException(String message) {
        super(message);
    }
}
