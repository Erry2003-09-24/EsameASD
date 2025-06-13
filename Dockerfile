# STAGE 1: Build
FROM maven:3.9.9-eclipse-temurin-21 AS build

# Imposta la directory di lavoro nel container
WORKDIR /app

# Copia tutti i file del progetto
COPY . .

# Costruisce il progetto, puoi aggiungere -DskipTests se non vuoi eseguire i test
RUN mvn clean package -DskipTests

# STAGE 2: Runtime
FROM openjdk:24-jdk-slim

# Imposta la directory di lavoro nel container
WORKDIR /app

# Copia il jar creato nella fase di build
COPY --from=build /app/target/Esame_Automated_Software_Delivery-1.0-SNAPSHOT.jar app.jar

# Comando di avvio dell'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]
