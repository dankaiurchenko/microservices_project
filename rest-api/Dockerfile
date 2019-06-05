FROM openjdk:8-jre
ADD target/rest-api.jar rest-api.jar
EXPOSE 8081
VOLUME /logs
ENTRYPOINT ["java", "-jar", "rest-api.jar"]