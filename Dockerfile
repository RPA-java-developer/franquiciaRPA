# ETAPA 1: BUILD
FROM maven:3.9.8-eclipse-temurin-21 AS builder

# Configura el directorio de trabajo
WORKDIR /app

# Copia los archivos del proyecto y compila (ejemplo con Maven)
COPY . .
RUN ./mvnw clean install


# ETAPA 2: RUN (Producción)
FROM maven:3.9.8-eclipse-temurin-21

WORKDIR /app

# Copia el jar generado desde la etapa 1
COPY --from=builder /app/target/mi-aplicacion.jar app.jar

# Expone el puerto de la aplicación y ejecuta el jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]