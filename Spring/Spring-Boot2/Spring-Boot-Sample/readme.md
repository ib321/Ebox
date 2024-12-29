# Spring Boot Basic Program

## Developer
@IB

## Project Description
This project is a simple "Hello World" web application developed using Spring Boot and JSP. It serves as a basic example to demonstrate the setup and configuration of a Spring Boot application for first-time users.

## Technologies Used
- Java Development Kit (JDK) 8 or higher
- Spring Boot 2.4.0
- Maven 3.2+
- devtool
- JSP as UI

## Installation Guide
### Step 1: Clone the Repository
```sh
git clone https://github.com/path to repo/Spring-Boot-Sample.git
cd Spring-Boot-Sample
```

### Step 2: Build the Project
```sh
mvn clean install
```

### Step 3: Run the Application
```sh
mvn spring-boot:run
```
1. Right-click on the project and Run as Spring Boot App.
Or
1. Go to `src/main/java/com/example/hello`.
2. Open `HelloWorldApplication.java`.
3. Then Run as Java Application.

### Step 4: Access the Application
Open a web browser and navigate to `http://localhost:8098` to see the some basic message output.

## Project Structure
- `src/main/java`: Contains the Java source code.
  - `com.example.hello`: Contains the main application class `HelloWorldApplication.java`.
- `src/main/resources`: Contains the application properties and static resources.
  - `application.properties`: Configuration file for the Spring Boot application.
  - `webapp`: Contains JSP files.
- `pom.xml`: Maven configuration file.