FROM openjdk:17 AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:17
WORKDIR demo-elasticsearch
COPY --from=build target/*.jar demo-elasticsearch.jar
ENTRYPOINT ["java", "-jar", "demo-elasticsearch.jar"]