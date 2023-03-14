# FROM amazoncorretto:19-alpine-jdk
# MAINTAINER leilenkalbermatter
# COPY target/backend-0.0.1-SNAPSHOT.jar backend-0.0.1-SNAPSHOT.jar
# ENTRYPOINT ["java","-jar","backend-0.0.1-SNAPSHOT.jar"]

#
# Build stage
#
FROM maven:3.6.2-jdk-19 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:19-alpine
COPY --from=build /target/backend-0.0.1-SNAPSHOT.jar backend.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","backend.jar"]