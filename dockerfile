FROM maven:3.9-eclipse-temurin-21-alpine as builder
WORKDIR /app
COPY . .
RUN mvn clean package -Dskiptests

# Cria uma imagem com Maven e java 21, copia todo o projeto para 
# dentro do container, RUN compila o projeto, clean limpa builds antigos
# package cria o .jar, -Dskiptests -> Pula testes.

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ]
#