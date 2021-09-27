#!/bin/zsh
./mvnw clean package -DskipTests 
docker-compose down                   
docker rmi spring-boot-docker
docker-compose up 