# Stage 1: Build
FROM eclipse-temurin:17-jdk-jammy as builder
WORKDIR /app
COPY . .
# Medium: Кэширование секретов в build stage
RUN ./gradlew build

# Stage 2: Runtime
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

# Medium: Отсутствие non-root пользователя
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]