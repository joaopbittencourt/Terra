# Stage 1: Build the application
FROM maven:3.9.6-eclipse-temurin-22-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package && java -jar

# Stage 2: Create the runtime image
FROM eclipse-temurin:22
WORKDIR /app

# FIX: Ensure you are copying the fat executttable jar, not the .jar.original file
COPY -- from=build /out/artifacts/terra_jar/terra.jar app.jar

EXPOSE 3000
ENTRYPOINT ["java", "-jar", "app.jar"]


FROM eclipse-temurin:17

ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","hello.Application"]