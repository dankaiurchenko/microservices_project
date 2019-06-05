FROM openjdk:8-jre
ADD target/rest-api.jar  /app/
CMD ["java", "-Xmx200m", "-jar", "/app/rest-api.jar"]
EXPOSE 8081