FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /src
COPY . .
RUN mvn clean package -DskipTests

# Étape 2 : image d’exécution
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]