FROM openjdk:17
LABEL authors="gnatykdm"

WORKDIR /app
COPY target/core-0.0.1-SNAPSHOT.war /app/core-0.0.1-SNAPSHOT.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "core-0.0.1-SNAPSHOT.war"]