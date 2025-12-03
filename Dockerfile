# Use OpenJDK 17 avec Alpine
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copier le JAR
COPY target/student-management-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
