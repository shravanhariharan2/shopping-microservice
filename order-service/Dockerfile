FROM maven:3.6.3-jdk-11-slim as builder
RUN mkdir -p /src/order-service
WORKDIR /src/order-service
COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B
COPY . .
RUN mvn package


FROM openjdk:11-jdk-slim
COPY --from=builder /src/order-service/target/order-service.jar /src/order-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/src/order-service.jar"]
