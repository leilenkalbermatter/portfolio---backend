FROM amazoncorretto:19-alpine-jdk
MAINTAINER leilenkalbermatter
COPY target/backend-0.0.1-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java","-jar","backend.jar"]