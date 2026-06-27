# Spring Boot Starter Application

This repository contains a hands-on backend application built while mastering the fundamentals of the Spring Boot ecosystem. The project focuses on setting up an enterprise-grade Java environment, handling database connectivity, and modeling complex relationships.

## Local Development Setup

1. Create a `.env` file in the project root using `.env.example` as a reference.
2. Keep the app-facing variables simple:
	- `JWT_SECRET` is reserved for future JWT auth.
	- `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` are used by Spring Boot.
3. Start PostgreSQL and pgAdmin with Docker Compose:

	```bash
	docker compose up -d
	```

4. Run the Spring Boot app with the values from `.env` loaded automatically at startup.
5. Open pgAdmin at `http://localhost:5050` and register the PostgreSQL server using:
	- Host: `postgres`
	- Port: `5432`
	- Database: `creatorstore`
	- Username: `postgres`
	- Password: `postgres`

`DB_URL` uses `localhost:5434` because your Spring Boot app runs on your machine, while PostgreSQL runs in Docker and exposes port `5434` to the host. Docker creates the database automatically because `POSTGRES_DB` is set in [docker-compose.yml](docker-compose.yml). You only need to create it manually in pgAdmin if you want to inspect or recreate it later.

## Tech Stack & Tools
* **Language:** Java
* **Framework:** Spring Boot
* **Database:** PostgreSQL
* **Data Access:** JDBC & Hibernate (ORM)

## Key Features Implemented
* **Spring Boot Configuration:** Standard architecture setup with cleanly decoupled controller, service, and repository layers.
* **PostgreSQL Integration:** Configured robust data persistence utilizing native JDBC connections.
* **Entity Relationships:** Modeled relational data structures and mappings seamlessly using Hibernate.
