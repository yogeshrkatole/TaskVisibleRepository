FROM maven:3.6.3-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11.0.11-jdk-slim
COPY --from=build /target/NicheSoftwareTask-0.0.1-SNAPSHOT.jar NicheSoftwareTask.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "NicheSoftwareTask.jar"]