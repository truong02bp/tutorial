FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} service-register.jar
ENTRYPOINT ["java", "-jar", "/service-register.jar"]
EXPOSE 8761