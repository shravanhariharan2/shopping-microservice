FROM openjdk:11 as builder
RUN mkdir -p /src/item-service
COPY . ./src/item-service
WORKDIR /src/item-service
RUN ./mvnw clean package


FROM builder
COPY --from=builder /src/item-service/target/item-service.jar /src/item-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/src/item-service.jar"]
