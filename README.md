# # Barbershop Backend

## 📌 Sobre o projeto

API REST para gerenciamento de barbearia desenvolvida com Java e Spring Boot.

O projeto utiliza PostgreSQL como banco de dados, Docker para conteinerização, Flyway para versionamento do banco e Spring Security para proteção dos endpoints.

## 🚀 Tecnologias

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* PostgreSQL
* Docker
* Flyway
* Maven
* Git e GitHub

## 📂 Arquitetura

O projeto segue arquitetura em camadas:

* Controller
* Service
* Repository
* Entity
* DTO
* Exception Handler

## ✅ Funcionalidades implementadas

### Clientes

* Criar cliente
* Listar clientes
* Buscar cliente por ID
* Atualizar cliente
* Remover cliente

### Barbeiros

* Criar barbeiro
* Listar barbeiros
* Buscar barbeiro por ID
* Atualizar barbeiro
* Remover barbeiro

## ⚠️ Tratamento de erros

A API possui tratamento global de exceções utilizando:

* GlobalExceptionHandler
* ErrorResponseDTO

## 🐳 Executando o projeto

### Subir banco de dados

```bash
docker compose up -d
```

### Executar aplicação

```bash
./mvnw spring-boot:run
```

## 🔮 Próximos passos

* Agendamentos (Appointment)
* Swagger/OpenAPI
* JWT Authentication
* Testes unitários
* Deploy
