FROM 3.9.9-eclipse-temurin-23-alpine as build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:23-jdk-slim
COPY --from=build /target/verifycertificate-0.0.1-SNAPSHOT.jar verifycertificate.jar
EXPOSE 8090

ENTRYPOINT ["java", "-jar", "verifycertificate.jar"]