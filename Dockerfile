FROM openjdk:17-jdk-slim AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:17-jdk-slim
WORKDIR basket-service
COPY --from=build target/*.jar basket-service.jar
ENTRYPOINT ["java", "-jar", "basket-service.jar"]