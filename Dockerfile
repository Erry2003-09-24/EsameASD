# Stage 1: Build con Java 24 e Maven
FROM eclipse-temurin:24-jdk AS build

# Installa Maven
RUN apt-get update && apt-get install -y maven

WORKDIR /app

# Copia pom.xml e checkstyle.xml per caching e checkstyle
COPY pom.xml checkstyle.xml ./

# Scarica dipendenze offline
RUN mvn dependency:go-offline

# Copia il resto del progetto
COPY src /app/src

# Compila il progetto senza test
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:24-jre

WORKDIR /app

# Copia il jar compilato dallo stage build
COPY --from=build /app/target/*.jar app.jar

# Comando per avviare l'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]
