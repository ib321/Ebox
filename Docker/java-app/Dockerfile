# Use a base image with Java runtime
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Hello.java file to the working directory in the container
COPY Hello.java /app/

# Compile the HelloWorld.java file
RUN javac Hello.java

# Command to run the compiled Java program
CMD ["java", "Hello"]
