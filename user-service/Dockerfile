FROM openjdk:11
ADD target/user-service.jar user-service.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "user-service.jar"]
