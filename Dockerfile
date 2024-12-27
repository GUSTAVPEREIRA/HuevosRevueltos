FROM openjdk:23-jdk-slim as builder

RUN apt-get update && apt-get install -y maven
# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and source code to the container
COPY pom.xml ./
COPY src ./src


# Build the application using Maven
RUN mvn clean install -DskipTests

# Use a smaller image to run the application (avoiding unnecessary build tools)
FROM openjdk:23-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file built by Maven in the previous step
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the Spring Boot app runs on (default is 8080)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
