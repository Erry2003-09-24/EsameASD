# Use an official OpenJDK runtime as a parent image
FROM openjdk:24-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven-generated JAR file from your target directory into the container
COPY target/Esame_Automated_Software_Delivery-1.0-SNAPSHOT.jar app.jar

# Define the command to run your application
ENTRYPOINT ["java", "-jar", "app.jar"]