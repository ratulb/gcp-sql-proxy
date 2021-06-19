#FROM adoptopenjdk/openjdk11
FROM openjdk:11-jre-slim
#FROM openjdk:11-jre-slim-buster

MAINTAINER ratulb

COPY target/gcp-sql-proxy-0.0.1-SNAPSHOT.jar gcp-sql-proxy.jar

ENTRYPOINT ["java","-jar","/gcp-sql-proxy.jar"]
