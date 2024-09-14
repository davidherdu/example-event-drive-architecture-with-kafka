# Stage 1: Run the Eureka Server
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the locally built JAR file into the Docker container
COPY target/eureka-0.0.1-SNAPSHOT.jar /app/eureka.jar

# Copy the application.properties file into the container
COPY src/main/resources/application.properties /app/config/application.properties

# Expose the Eureka server default port
EXPOSE 8761

# Run the Eureka server
ENTRYPOINT ["java", "-jar", "/app/eureka.jar", "--spring.config.location=file:/app/config/application.properties"]
