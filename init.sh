#!/bin/bash



# Start Docker containers for each service
docker-compose up -d || { echo "Docker Compose failed"; exit 1; }

echo "All services have been started successfully"
