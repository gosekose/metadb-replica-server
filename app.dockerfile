# 빌드 스테이지
FROM gradle:8-jdk17 AS build
WORKDIR /app
COPY build.gradle .
#COPY gradle.properties .
COPY settings.gradle .
COPY gradlew .
COPY gradle ./gradle
RUN chmod +x ./gradlew
RUN ./gradlew build --no-daemon 

COPY src ./src
RUN ./gradlew build --no-daemon 

# 실행 스테이지
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
