# Spring Boot Login Project

## Overview
This project is a simple Spring Boot application that demonstrates a basic login functionality. It includes user authentication and authorization using Spring Security.

## Features
- User Registration
- User Login/Logout using spring security
- User Validations
- Password Encryption
- Role-based Access Control [Not fully implemented]
- UI based on Thymeleaf

## Technologies Used
- Java 8
- Spring Boot 2.3.4.RELEASE
- Spring Security
- Thymeleaf
- H2 Database
- Spring Data JPA
- Maven for dependency management

## Setup Instructions

1. **Clone the repository:**
    ```bash
    git clone https://github.com/path to repo/Spring-Boot-Login.git
    cd Spring-Boot-Login
    ```

2. **Build the project:**
    ```bash
    mvn clean install
    ```

3. **Run the application:**
    ```bash
    mvn spring-boot:run
    ```

4. **Access the application:**
    Open your browser and navigate to `http://localhost:8098`.

## Configuration
- The application uses an in-memory H2 database for demonstration purposes. You can configure the database settings in the `application.properties` file.
- you can access h2 database console at `localhost:8098/h2-console`

## Folder Structure
```
Spring-Boot-Login/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── ib/
│   │   │           └── springlogin/
│   │   │               ├── model/
│   │   │               ├── repository/
│   │   │               ├── service/
│   │   │               ├── web/
│   │   │               └── DemoApplication.java
│   │   │               └── WebSecurityConfig.java
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       └── application.properties
│   │       └── validation.properties
├── pom.xml
└── README.md
```

## Contributing
Contributions are welcome! Please open an issue or submit a pull request for any changes.
