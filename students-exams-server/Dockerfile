# Stage 1: Run the Student Exams Server
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the locally built JAR file into the Docker container
COPY target/students-exams-server-0.0.1-SNAPSHOT.jar /app/students-exams-server.jar

# Copy the application.properties file into the container
COPY src/main/resources/application.properties /app/config/application.properties

# Expose the Student Exams Server default port
EXPOSE 8081

# Run the Student Exams Server
ENTRYPOINT ["java", "-jar", "/app/students-exams-server.jar", "--spring.config.location=file:/app/config/application.properties"]
