FROM openjdk:11
LABEL authors="Claudio"

# Copia o arquivo JAR do seu projeto para dentro do container
COPY target/acervocesar-0.0.1-SNAPSHOT.jar /app/acervocesar-0.0.1-SNAPSHOT.jar

# Define o diretório de trabalho
WORKDIR /app

# Expõe a porta do seu projeto
EXPOSE 8080

CMD ["java", "-jar", "acervocesar-0.0.1-SNAPSHOT.jar"]