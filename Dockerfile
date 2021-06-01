FROM openjdk:11-jre-slim
RUN apt-get update
ARG JAR_FILE=target/*.jar.original
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
