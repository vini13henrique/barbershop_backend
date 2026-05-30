package com.barbershop.barbershop.exception;

import com.barbershop.barbershop.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidClientDataException.class)
    public ResponseEntity<ErrorResponseDTO> handlerInvalidClientData(InvalidClientDataException exception) {

        ErrorResponseDTO erro = new ErrorResponseDTO(400, exception.getMessage(), LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(InvalidBarberDataException.class)
    public ResponseEntity<ErrorResponseDTO> handlerInvalidBarberData(InvalidBarberDataException exception) {

        ErrorResponseDTO erro = new ErrorResponseDTO(400, exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(BarberNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handlerBarberNotFound(BarberNotFoundException exception) {

        ErrorResponseDTO erro = new ErrorResponseDTO(404, exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handlerClientNotFound(ClientNotFoundException exception) {

        ErrorResponseDTO erro = new ErrorResponseDTO(404, exception.getMessage(), LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }


}
