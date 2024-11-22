# Stage 1: Build the application
FROM maven:3.8.8-openjdk-11 AS build
WORKDIR /app

# Copy the entire project to the container
COPY . .

# Build the project
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:11-jre-slim
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/Yogesh_Katole_9359972045-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
