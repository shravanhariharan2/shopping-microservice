FROM maven:3.6.3-jdk-11-slim as builder
RUN mkdir -p /src/user-service
WORKDIR /src/user-service
COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B
COPY . .
RUN mvn package


FROM openjdk:11-jdk-slim
COPY --from=builder /src/user-service/target/user-service.jar /src/user-service.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "/src/user-service.jar"]
