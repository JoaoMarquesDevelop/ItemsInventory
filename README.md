# Inventory

A product management system built with Spring Boot.

## Preparing Your Local Environment

### Prerequisites

- **Java 23**: You can use Amazon Coretto
- **Docker**: Use docker to start a MySQL container, to run our database

### Setting Up the Backend

1. Install amazon coretto 23 and set it to JAVA_HOME

2. Start Docker

3. Run the Spring Boot application:
    
    - go to folder
    ```bash
    cd backend
    ```
    - Start!

    ```bash
    mvn spring-boot:run -Dspring-boot.run.profiles=dev
    ```

    This will automatically start a mysql container and prepare your db with default data

### Setting Up the Frontend

1. Navigate to the frontend directory:

    ```bash
    cd frontend
    ```

2. Install dependencies:

    ```bash
    npm install
    ```

3. Start the frontend application:

    ```bash
    npm start
    ```