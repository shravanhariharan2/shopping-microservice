FROM maven:3.6.3-jdk-11-slim as builder
RUN mkdir -p /src/item-service
WORKDIR /src/item-service
COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B
COPY . .
RUN mvn package


FROM openjdk:11-jdk-slim
COPY --from=builder /src/item-service/target/item-service.jar /src/item-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/src/item-service.jar"]
