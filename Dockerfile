FROM openjdk:11-jre-slim

# Copiar o .jar gerado pelo Maven para o contêiner
COPY target/housing_cost_simulator-0.0.1-SNAPSHOT.jar app.jar

# Defina o ponto de entrada para a aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]