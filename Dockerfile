FROM maven:3.8.7-openjdk-18-slim as build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:18-slim
COPY --from=build /target/verifycertificate-0.0.1-SNAPSHOT.jar verifycertificate.jar
EXPOSE 8090

ENTRYPOINT ["java", "-jar", "verifycertificate.jar"]