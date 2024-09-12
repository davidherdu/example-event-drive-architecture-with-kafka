# Stage 1: Build the Eureka Server
FROM maven:3.8.4-openjdk-17 AS builder

WORKDIR /app

# Copy the Maven POM file and install dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the Eureka Server
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/eureka-0.0.1-SNAPSHOT.jar /app/eureka.jar

# Expose the Eureka server default port
EXPOSE 8761

# Run the Eureka server
ENTRYPOINT ["java", "-jar", "/app/eureka.jar"]
