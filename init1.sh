#!/bin/bash

# Function to run Maven clean install and handle errors
run_maven_install() {
    cd "$1" || { echo "Directory not found: $1"; exit 1; }
    mvn clean install -DskipTests || { echo "Maven build failed in $1"; exit 1; }
    cd - > /dev/null # Go back to the previous directory, suppress output
}

# Function to run Maven clean package and handle errors
run_maven_package() {
    cd "$1" || { echo "Directory not found: $1"; exit 1; }
    mvn clean package -DskipTests || { echo "Maven package failed in $1"; exit 1; }
    cd - > /dev/null # Go back to the previous directory, suppress output
}

# Build the custom libraries
run_maven_install "maven-libraries/students-exams-dtos"
run_maven_install "maven-libraries/students-exams-models"
run_maven_install "maven-libraries/students-exams-mappers"
run_maven_install "maven-libraries/distributed-dtos"
run_maven_install "maven-libraries/distributed-models"
run_maven_install "maven-libraries/distributed-mappers"

# Build the microservices and the Eureka server
run_maven_package "eureka"
run_maven_package "students-exams-frontend"
run_maven_package "students-exams-server"
run_maven_package "teacher-exams-application"

# Start Docker containers for each service
docker-compose up -d || { echo "Docker Compose failed"; exit 1; }

echo "All services have been started successfully"
