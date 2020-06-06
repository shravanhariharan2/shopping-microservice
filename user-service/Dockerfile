FROM openjdk:11 as builder
RUN mkdir -p /src/user-service
COPY . ./src/user-service
WORKDIR /src/user-service
RUN ./mvnw clean package


FROM builder
COPY --from=builder /src/user-service/target/user-service.jar /src/user-service.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "/src/user-service.jar"]
