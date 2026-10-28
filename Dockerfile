FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /app

COPY gradlew settings.gradle build.gradle ./
COPY gradle ./gradle
COPY src ./src

RUN chmod +x gradlew
RUN ./gradlew --no-daemon clean bootJar
RUN cp build/libs/*.jar app.jar

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /app/app.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
