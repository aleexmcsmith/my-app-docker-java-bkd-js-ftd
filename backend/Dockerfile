# Use the official OpenJDK 17 slim image
# FROM eclipse-temurin:21-jre-alpine

# # Set working directory inside the container
# WORKDIR /app

# # Copy the Maven-built JAR file into the container
# COPY target/*.jar app.jar

# # Expose port 8080 (Spring Boot default)
# EXPOSE 8080

# # Run the JAR file
# ENTRYPOINT ["java", "-jar", "app.jar"]


# ===== STAGE 1: Build =====
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

# Copy Maven wrapper and pom.xml first (for caching)
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Make mvnw executable (Windows users: this still works in Linux container)
RUN chmod +x mvnw

# Download dependencies (cached if pom.xml unchanged)
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src src

# Build the JAR (skip tests for speed)
RUN ./mvnw package -DskipTests

# ===== STAGE 2: Runtime =====
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy the JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]