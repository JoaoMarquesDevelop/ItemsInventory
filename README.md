# Inventory

A product management system built with Spring Boot.

## Preparing Your Local Environment

### Prerequisites

- **Java 23**: You can use Amazon Coretto
- **Docker**: Use docker to start a MySQL container, to run our database

### Setting Up the Backend

1. **Start the MySQL container**:  
   In the backend/docker directory, use Docker Compose to start the MySQL container:
   ```bash
   docker compose -d
   ```

2. Run the Spring Boot application:
    This will automatically trigger the schema.sql and data.sql scripts to set up the database default tables and rows.
    ```bash
    mvn spring-boot:run -Dspring-boot.run.profiles=dev
    ```

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