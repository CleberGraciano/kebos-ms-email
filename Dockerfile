FROM maven:3.8.2-jdk-11
WORKDIR /app
COPY . .
RUN mvn clean install
EXPOSE 8080
CMD ["java", "-jar", "./target/kebos-ms-email-1.0.0.jar"]