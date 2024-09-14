# Stage 1: Run the Student Exams Frontend
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the locally built JAR file into the Docker container
COPY target/students-exams-frontend-0.0.1-SNAPSHOT.jar /app/students-exams-frontend.jar

# Copy the application.properties file into the container
COPY src/main/resources/application.properties /app/config/application.properties

# Expose the Student Exams Frontend default port
EXPOSE 8082

# Run the Student Exams Frontend
ENTRYPOINT ["java", "-jar", "/app/students-exams-frontend.jar", "--spring.config.location=file:/app/config/application.properties"]
