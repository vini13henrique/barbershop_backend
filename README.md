# 💈 Barbershop Backend

## 📌 Sobre o projeto

API REST para gerenciamento de barbearia desenvolvida com Java e Spring Boot.

O projeto foi criado com o objetivo de praticar conceitos utilizados em aplicações reais de backend, incluindo arquitetura em camadas, persistência de dados, versionamento de banco de dados, segurança e boas práticas de desenvolvimento.

A aplicação utiliza PostgreSQL como banco de dados, Docker para conteinerização, Flyway para versionamento do banco e Spring Security para proteção dos endpoints.

---

## 🚀 Tecnologias

* Java 21
* Spring Boot 3
* Spring Security
* Spring Data JPA
* PostgreSQL
* Docker
* Flyway
* Maven
* Git
* GitHub

---

## 📂 Arquitetura

O projeto segue uma arquitetura em camadas:

* Controller
* Service
* Repository
* Entity
* DTO
* Exception Handler
* Flyway Migrations
* Spring Security

---

## ✅ Funcionalidades implementadas

### 👥 Clientes

* Criar cliente
* Listar clientes
* Buscar cliente por ID
* Atualizar cliente
* Remover cliente

### ✂️ Barbeiros

* Criar barbeiro
* Listar barbeiros
* Buscar barbeiro por ID
* Atualizar barbeiro
* Remover barbeiro

### 📅 Agendamentos

* Criar agendamento
* Listar agendamentos
* Buscar agendamento por ID
* Atualizar agendamento
* Remover agendamento
* Validação de regras de negócio

---

## ⚠️ Tratamento de erros

A API possui tratamento global de exceções utilizando:

* GlobalExceptionHandler
* ErrorResponseDTO
* Exceções customizadas

Exemplos:

* ClientNotFoundException
* BarberNotFoundException
* AppointmentNotFoundException
* InvalidAppointmentDataException

---

## 🏗️ Recursos implementados

* DTO Pattern
* Relacionamentos JPA
* Validações de negócio
* Tratamento global de exceções
* ErrorResponseDTO
* PostgreSQL
* Docker
* Flyway
* Spring Security
* Histórico de commits utilizando Git

---

## 🚧 Status do Projeto

Projeto em desenvolvimento ativo.

### Concluído

* CRUD de Clientes
* CRUD de Barbeiros
* Sistema de Agendamentos
* DTO Pattern
* Relacionamentos JPA
* Global Exception Handler
* ErrorResponseDTO
* PostgreSQL
* Docker
* Flyway
* Spring Security

### Em andamento

* Evolução das regras de negócio
* Melhorias de validação

---

## 🐳 Executando o projeto

### 1. Subir o banco de dados

```bash
docker compose up -d
```

### 2. Executar a aplicação

```bash
./mvnw spring-boot:run
```

---

## 🔮 Próximos passos

* JWT Authentication
* Swagger/OpenAPI
* Paginação e filtros
* Testes unitários
* Testes de integração
* Deploy

---

## 👨‍💻 Autor

Vinicius Henrique

LinkedIn:
https://www.linkedin.com/in/vinicius-henrique-ll/

GitHub:
https://github.com/vini13henrique

