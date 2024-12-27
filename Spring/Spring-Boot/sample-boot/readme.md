# Sample Spring Boot Project

This is a simple Spring Boot maven based project that demonstrates the use of services and static data as the backend. This project does not use a database.

## Prerequisites

- Java
- Maven

## Endpoints
There are 3 endpoints to use for demo
- `GET /hall/list` - Returns static demo data.

## Example

### Request

```sh
curl -X GET http://localhost:8098/hall/list
```

## Getting Started

you can run this after cloning this repo

1. Clone the repository:(Insert the actual url of the repo)
    ```sh
    git clone https://github.com/your-username/sample-boot.git
    cd sample-boot
    ```

2. Build the project:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```
