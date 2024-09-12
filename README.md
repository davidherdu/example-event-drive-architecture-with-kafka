# Example Event-Driven Architecture with Kafka

This repository demonstrates a sample event-driven architecture using Kafka with Spring Boot applications. The architecture consists of multiple components that interact with each other using Kafka events and REST APIs.

## Project Overview

### 1. **students-exams-server**
- **Description:** A Spring Boot application responsible for storing students and exams in an H2 database. It publishes Kafka events when an exam is created and exposes a REST API for data access.
- **Technologies:** Spring Boot, H2 Database, Kafka, REST API

### 2. **students-exams-frontend**
- **Description:** A Spring Boot application that fetches data from `students-exams-server` using Spring Feign and displays lists of exams and students. It also allows creating new students and exams using a Thymeleaf-based UI.
- **Technologies:** Spring Boot, Spring Feign, Thymeleaf, REST API

### 3. **teacher-exams-application**
- **Description:** A Spring Boot application that consumes Kafka events produced by `students-exams-server`, stores the data in an H2 database, and provides a Thymeleaf-based UI for listing and updating exam marks.
- **Technologies:** Spring Boot, H2 Database, Kafka, Thymeleaf

### 4. **students-exams-models**
- **Description:** A Maven project containing the entities used by `students-exams-server` and `students-exams-frontend`.
- **Technologies:** Java, Maven

### 5. **students-exams-dtos**
- **Description:** A Maven project containing the DTOs (Data Transfer Objects) used by `students-exams-server` and `students-exams-frontend`.
- **Technologies:** Java, Maven

### 6. **students-exams-mappers**
- **Description:** A Maven project with mappers for transforming entities into DTOs and vice versa, used by `students-exams-server` and `students-exams-frontend`.
- **Technologies:** Java, Maven

### 7. **distributed-models**
- **Description:** A Maven project containing models used by `teacher-exams-application`.
- **Technologies:** Java, Maven

### 8. **distributed-dtos**
- **Description:** A Maven project containing models used by `students-exams-server` and `teacher-exams-application` to produce and consume Kafka events.
- **Technologies:** Java, Maven

### 9. **distributed-mapper**
- **Description:** A Maven project with mappers for transforming entities into DTOs and vice versa, used by `students-exams-server` and `teacher-exams-application`.
- **Technologies:** Java, Maven

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher
- Apache Kafka (running locally or in a Docker container)
- H2 Database

### Setup and Configuration

1. **Clone the Repository**

   ```bash
   git clone https://github.com/davidherdu/example-event-drive-architecture-with-kafka.git
   cd example-event-drive-architecture-with-kafka
 
