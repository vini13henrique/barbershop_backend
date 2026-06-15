CREATE TABLE appointments
(
    id               BIGSERIAL PRIMARY KEY,
    appointment_date TIMESTAMP NOT NULL,
    barber_id        BIGINT    NOT NULL,
    client_id        BIGINT    NOT NULL,
    FOREIGN KEY (barber_id) REFERENCES barbers (id),
    FOREIGN KEY (client_id) REFERENCES clients (id)
);