FROM openjdk:11-jre-slim
WORKDIR /build
COPY target/housing_cost_simulator-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]