# Stage 1: Build con Java 24 e Maven
FROM eclipse-temurin:24-jdk AS build

# Installa Maven
RUN apt-get update && apt-get install -y maven

WORKDIR /app

# Copia solo il pom per caching delle dipendenze
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia il resto del progetto
COPY src /app/src

# Compila il progetto
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:24-jre

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Comando per avviare l'app (adatta il nome JAR se necessario)
ENTRYPOINT ["java", "-jar", "app.jar"]
