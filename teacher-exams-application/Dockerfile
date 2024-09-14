# Stage 1: Run the Teacher Exams Application
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the locally built JAR file into the Docker container
COPY target/teacher-exams-application-0.0.1-SNAPSHOT.jar /app/teacher-exams-application.jar

# Copy the application.properties file into the container
COPY src/main/resources/application.properties /app/config/application.properties

# Expose the Teacher Exams Application default port
EXPOSE 8083

# Run the Teacher Exams Application
ENTRYPOINT ["java", "-jar", "/app/teacher-exams-application.jar", "--spring.config.location=file:/app/config/application.properties"]
