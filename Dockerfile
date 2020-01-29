FROM openjdk:13-ea-jdk-alpine
VOLUME /tmp
ADD /target/kubernetes*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar", "/app.jar"]