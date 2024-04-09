# Imagen base
FROM openjdk:8-jdk-alpine

# Directorio en el contenedor
WORKDIR /app

# Copiar el .jar a la imagen
COPY bankaya-soap/target/bankaya-soap-0.0.1-SNAPSHOT.jar /app/bankaya-app.jar


# Comando para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "/app/bankaya-app.jar"]