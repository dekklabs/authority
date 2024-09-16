FROM gradle:7.6.2-jdk17 AS build
WORKDIR /app

COPY build.gradle settings.gradle ./
RUN gradle build --no-daemon -x test

COPY . .
RUN gradle build --no-daemon -x test

FROM openjdk:17-jdk-slim
WORKDIR /app

#COPY --from=build /app/build/libs/tu-app-springboot.jar app.jar
COPY --from=build /app/build/libs/backpruebatecnica-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]