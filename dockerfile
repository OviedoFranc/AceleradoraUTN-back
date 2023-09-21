# Usa una imagen base de JDK 17
FROM openjdk:17-alpine

# Directorio donde nuestra aplicación se ejecutará dentro del contenedor
WORKDIR /app

# Copio cualquier JAR compilado al contenedor
COPY target/*.jar /app/app.jar