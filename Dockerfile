# Stage 1: Build
FROM maven:3.8.6-openjdk-11 AS build
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn clean install -DskipTests

# Stage 2: Run
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/NicheSoftwareTask-0.0.1-SNAPSHOT.jar NicheSoftwareTask.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "NicheSoftwareTask.jar"]
