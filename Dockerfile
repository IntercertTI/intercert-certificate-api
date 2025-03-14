FROM openjdk:25-jdk-slim

WORKDIR /app

ARG JAR_FILE=target/verifycertificate-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /app/app_intercert_verificar_certificado.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/app/app_intercert_verificar_certificado.jar"]