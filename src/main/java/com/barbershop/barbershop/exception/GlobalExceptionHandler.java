package com.barbershop.barbershop.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidClientDataException.class)
    public ResponseEntity<String> handlerInvalidClientData(InvalidClientDataException exception) {

        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
