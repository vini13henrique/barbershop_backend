package com.barbershop.barbershop.controller;

import com.barbershop.barbershop.dto.AppointmentRequestDTO;
import com.barbershop.barbershop.dto.AppointmentResponseDTO;
import com.barbershop.barbershop.entity.Appointment;
import com.barbershop.barbershop.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping()
    public ResponseEntity<AppointmentResponseDTO> createAppointment(@RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        AppointmentResponseDTO appointmentNovo = appointmentService.createAppointment(appointmentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentNovo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponseDTO> findById(@PathVariable Long id) {
        AppointmentResponseDTO appointmentId = appointmentService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(appointmentId);
    }

    @GetMapping()
    public ResponseEntity<List<AppointmentResponseDTO>> getAll() {
        List<AppointmentResponseDTO> appointmentResponseDTOS = appointmentService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(appointmentResponseDTOS);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentResponseDTO> update(@PathVariable Long id, @RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        AppointmentResponseDTO appointmentAtualizado = appointmentService.update(id, appointmentRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(appointmentAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        appointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
