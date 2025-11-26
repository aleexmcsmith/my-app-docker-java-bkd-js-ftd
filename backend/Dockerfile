# Use the official OpenJDK 17 slim image
FROM eclipse-temurin:21-jre-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the Maven-built JAR file into the container
COPY target/*.jar app.jar

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]