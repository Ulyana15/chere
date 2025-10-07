# Используем самый маленький базовый образ
FROM alpine:latest

# Medium уязвимость: работа от root (оставляем как есть)
USER root

WORKDIR /app

# Создаем простой файл вместо Java приложения
RUN echo "Hello Checkmarx Security Scan" > hello.txt

# Medium уязвимость: открываем порт
EXPOSE 8080

# Простая команда
CMD ["cat", "hello.txt"]