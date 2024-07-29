FROM maven:3.8.5-openjdk-17-slim AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean install -DskipTests

# Imagen final
FROM alpine:latest

RUN apk add --no-cache openjdk17

RUN mkdir -p /app

COPY --from=build /app/target/*.jar /app/

CMD ["sh", "-c", "java -jar /app/*.jar"]
