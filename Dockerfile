# Imagen base con Java 21 (recomendada para Spring Boot 3)
FROM eclipse-temurin:21-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el JAR generado por Maven
COPY target/libreria-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto de la aplicación
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
