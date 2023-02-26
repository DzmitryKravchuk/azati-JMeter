FROM openjdk:11-jdk-slim

COPY simpleApp/build/libs/simpleApp-1.0-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
