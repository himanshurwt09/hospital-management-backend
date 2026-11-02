# Hospital Management Backend

A Spring Boot backend that models a hospital system, built to practice JPA/Hibernate relationships, queries and cascading.

## Tech Stack
- Java 21, Spring Boot
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven

## Entities and Relationships
- Patient to Insurance: One-to-One
- Patient to Appointment: One-to-Many / Many-to-One
- Appointment to Doctor: Many-to-One
- Department to Doctor: Many-to-Many (join table)
- Department to Head Doctor: One-to-One

## Concepts Covered
- Derived query methods and custom JPQL queries
- Native queries and pagination
- DTO projections
- Cascading and orphanRemoval
- Dirty checking with @Transactional
- Owning vs inverse side in bidirectional mappings

## Setup
1. Create a PostgreSQL database named `HospitalDB`.
2. Set your username and password in `src/main/resources/application.properties`.
3. Run `HospitalManagmentApplication`. Sample data loads from `data.sql`.

Note: `ddl-auto=create` recreates the tables on every start.
