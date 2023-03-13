FROM amazoncorretto:18-alpine-jdk
MAINTAINER leilenkalbermatter
COPY out/artifacts/portfolio___backend_jar/portfolio---backend.jar portfolio---backend.jar
ENTRYPOINT ["java","-jar","/portfolio---backend.jar"]