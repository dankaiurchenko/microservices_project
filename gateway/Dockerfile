FROM openjdk:8-jre
ADD target/gateway.jar gateway.jar
EXPOSE 8080
VOLUME /logs
ENTRYPOINT ["java", "-jar", "gateway.jar"]