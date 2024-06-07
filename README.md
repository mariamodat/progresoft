# FX Deal Management Application

The FX Deal Management Application is a Spring Boot application designed to manage FX deals. It provides endpoints to create, retrieve, update, and delete FX deals.

## Features

- Create new FX deals
- Retrieve FX deals by unique ID
- Handle duplicate FX deals gracefully
- Integration with PostgreSQL database
- Unit tests for service methods

### Technologies Used
* Java 17
* Spring Boot 3.2.5
* Spring Data JPA
* Postgres db
* redis Database (for caching)
* JUnit 5 and Mockito (for unit and integration tests)
* Maven (for build and dependency management)
* liquibase for db migration
* redis

## Prerequisites

- Java 17
- Maven
- Docker (for running with Docker Compose)
- PostgreSQL database (for running locally)
- redis (for caching)

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/mariamodat/progresoft.git
    ```

2. Navigate to the project directory:

    ```bash
    cd progresoft
    ```

3. Build the application:

    ```bash
    mvn clean package
    ```

## Usage

1. Run the application:

    ```bash
    java -jar target/progresoft-0.0.1-SNAPSHOT.jar

    ```
   ### you can run the docker image of the app by navigating to the root source of the app and run 
   ```
   mvn clean install 
   docker-compose up --build

2. Access the application at [http://localhost:9090](http://localhost:9090)

## Endpoints

- `POST /deals`: Create a new FX deal
- `GET /deals/{dealUniqueId}`: Retrieve an FX deal by unique ID

