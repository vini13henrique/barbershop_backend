ALTER TABLE appointments
    ADD CONSTRAINT uk_appointments_barber_datetime UNIQUE (barber_id, appointment_date);

ALTER TABLE appointments
    ADD CONSTRAINT uk_appointments_client_datetime UNIQUE (client_id, appointment_date);