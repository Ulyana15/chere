FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Минимальное содержимое
RUN echo 'public class Test { public static void main(String[] args) { System.out.println("Test"); } }' > Test.java && \
    javac Test.java

EXPOSE 8080

CMD ["java", "Test"]