FROM maven:3.9.0-amazoncorretto-11 as build

WORKDIR /build

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn package -DskipTests

FROM amazoncorretto:11-alpine3.19-jdk as runner

WORKDIR /app

COPY --from=build /build/target/housing_cost_simulator-0.0.1-SNAPSHOT.jar ./application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]
