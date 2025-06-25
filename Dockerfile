FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests
ENV WEATHER_API_KEY="6RPNJKFX95MCJDNXKFC73FA8A"

# Use OpenJDK 17 for the runtime stage
FROM openjdk:17-jdk-slim
COPY --from=build /target/Virtual-Closet-Organizer-0.0.1-SNAPSHOT.jar vco.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "vco.jar"]