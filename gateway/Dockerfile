FROM openjdk:8-jre
ADD target/gateway.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/gateway.jar"]
EXPOSE 8080