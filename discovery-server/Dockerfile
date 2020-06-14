FROM maven:3.6.3-jdk-11-slim as builder
RUN mkdir -p /src/discovery-server
WORKDIR /src/discovery-server
COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B
COPY . .
RUN mvn package


FROM openjdk:11-jdk-slim
COPY --from=builder /src/discovery-server/target/discovery-server.jar /src/discovery-server.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/src/discovery-server.jar"]
