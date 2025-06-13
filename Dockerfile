# STAGE 1: Build
FROM openjdk:24-jdk-slim AS build-base

# Installation of Maven 3.9.9
RUN apt-get update && apt-get install -y curl unzip && \
    curl -fsSL https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.zip -o maven.zip && \
    unzip maven.zip && mv apache-maven-3.9.9 /opt/maven && \
    ln -s /opt/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME=/opt/maven
ENV PATH=$MAVEN_HOME/bin:$PATH

WORKDIR /app
COPY . .

# Build con Maven + Java 24
RUN mvn clean package -DskipTests

# STAGE 2: Runtime
FROM openjdk:24-jdk-slim

WORKDIR /app
COPY --from=build-base /app/target/Esame_Automated_Software_Delivery-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
