# Stage 1: Build the shared libraries
FROM maven:3.8.4-openjdk-17 AS library_builder

WORKDIR /libs

# Copy and build the custom libraries
COPY ../maven-libraries/students-exams-dtos /libs/students-exams-dtos
COPY ../maven-libraries/students-exams-models /libs/students-exams-models
COPY ../maven-libraries/students-exams-mappers /libs/students-exams-mappers
COPY ../maven-libraries/distributed-dtos /libs/distributed-dtos
COPY ../maven-libraries/distributed-models /libs/distributed-models
COPY ../maven-libraries/distributed-mappers /libs/distributed-mappers
RUN cd /libs/students-exams-dtos && mvn clean install
RUN cd /libs/students-exams-models && mvn clean install
RUN cd /libs/students-exams-mappers && mvn clean install
RUN cd /libs/distributed-dtos && mvn clean install
RUN cd /libs/distributed-models && mvn clean install
RUN cd /libs/distributed-mappers && mvn clean install

# Stage 2: Build the microservice
FROM maven:3.8.4-openjdk-17 AS builder

WORKDIR /app

# Copy the microservice source code and pom.xml
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the microservice files and build the project
COPY src ./src
RUN mvn clean package

# Stage 3: Run the microservice
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the built jar file
COPY --from=builder /app/target/teacher-exams-application-0.0.1-SNAPSHOT.jar /app/teacher-exams-application.jar

# Expose the port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/teacher-exams-application.jar"]
