# -------- Stage 1: Build the Spring Boot app --------
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy pom and source
COPY pom.xml .
COPY src ./src

# Package the app (without tests)
RUN mvn clean package -DskipTests

# -------- Stage 2: Create the actual image --------
FROM openjdk:17-jdk-slim

WORKDIR /app

# Set environment variables
ENV JAVA_OPTS=""
ENV WEATHER_API_KEY="6RPNJKFX95MCJDNXKFC73FA8A"

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8091

ENTRYPOINT sh -c "java $JAVA_OPTS -jar app.jar"
