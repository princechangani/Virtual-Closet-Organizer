# Use a base image with Java
FROM openjdk:17-jdk-slim

# Set environment variables
ENV JAVA_OPTS=""
ENV WEATHER_API_KEY="6RPNJKFX95MCJDNXKFC73FA8A"

# Set working directory
WORKDIR /app

# Copy JAR file to container
COPY target/*.jar app.jar

# Expose the port your app runs on
EXPOSE 8091

# Run the app
ENTRYPOINT sh -c "java $JAVA_OPTS -jar app.jar"
