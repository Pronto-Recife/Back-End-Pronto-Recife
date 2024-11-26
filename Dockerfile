FROM maven:3.9.8-amazoncorretto-21 AS build
WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests -Dmaven.resources.encoding=UTF-8

FROM openjdk:21-jdk
WORKDIR /app

EXPOSE 8080

COPY --from=build /app/target/pronto-recife-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

FROM mysql:8.0.40-debian
COPY init.sql /docker-entrypoint-initdb.d/init.sql
EXPOSE 3306

