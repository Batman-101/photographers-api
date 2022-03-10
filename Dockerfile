FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY target/classes/*.json /resources/photographers.json

ENTRYPOINT ["java","-jar","/app.jar"]