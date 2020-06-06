FROM openjdk:11 as builder
RUN mkdir -p /src/order-service
COPY . ./src/order-service
WORKDIR /src/order-service
RUN ./mvnw clean package


FROM builder
COPY --from=builder /src/order-service/target/order-service.jar /src/order-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/src/order-service.jar"]
