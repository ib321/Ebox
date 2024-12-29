# Library Management System

This project is a Spring Boot (2.3.3.RELEASE) application for managing a library system. It provides functionalities to manage books, members, and transactions.

## Features

- This project is updated version of my old library management system project which was based on spring boot + Angular.
- Here I am using JSP for front end instead of angular. final goal was to integrate Spring security but I didn't.
- But it does have limited feature integration with JSP
- Add, update, and delete books
- Update return book timing and find avilability

below features are API based only
- Register and manage members
- View transaction history
- This is still compatible with my old angular UI although which version of that UI project not quite sure.

## Technologies Used

- Spring Boot 2.3.3.RELEASE
- Spring Data JPA
- H2 Database
- JSP
- Maven

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/path to repo/Library_Management_System.git
    ```
2. Navigate to the project directory:
    ```bash
    cd Library_Management_System
    ```
3. Build the project:    ```bash
    mvn clean install
    ```

### Running the Application

1. Run the application:
    ```bash
    mvn spring-boot:run
    ```
2. Open your browser and navigate to `http://localhost:8098`.

## Usage

- Use the web interface to manage books, members, and transactions.
- Access the H2 database console at `http://localhost:8080/h2-console`.
