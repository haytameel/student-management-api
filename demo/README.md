# Student Management API

This is a simple RESTful API for managing student data, built with Spring Boot and JPA/Hibernate. The API allows you to perform CRUD (Create, Read, Update, Delete) operations on student records, such as adding new students, retrieving student information, updating student details, and deleting students.

## Features

- Add new students to the database
- Retrieve a list of all students
- Update existing student information
- Delete students from the database
- Validation to prevent duplicate entries based on email

## Technologies Used

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA** for data persistence
- **Hibernate** as the JPA implementation
- **PostgreSQL** as the relational database management system
- **Maven** for project management and build

## Getting Started

### Setup

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/student-management-api.git
    cd student-management-api
    ```

2. **Configure PostgreSQL**:
    - Create a database in PostgreSQL for your application:
      ```sql
      CREATE DATABASE studentdb;
      ```
    - Update the `application.properties` file located in `src/main/resources/` with your PostgreSQL credentials:
      ```properties
      spring.datasource.url=jdbc:postgresql://localhost:5432/studentdb
      spring.datasource.username=your-username
      spring.datasource.password=your-password
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
      ```

3. **Build the project**:
    ```bash
    mvn clean install
    ```

4. **Run the application**:
    ```bash
    mvn spring-boot:run
    ```
   The application will start on `http://localhost:8080`.

### API Endpoints

- **GET /api/v1/student**: Retrieve a list of all students
- **POST /api/v1/student**: Add a new student
    - Example request body:
      ```json
      {
        "name": "Jose Fernandez",
        "email": "josefer@gmail.com",
        "birth": "2000-01-01"
      }
      ```
- **PUT /api/v1/student/{id}**: Update a student's information
    - Example request body:
      ```json
      {
        "name": "Maria Mercedes",
        "email": "mariamer@example.com"
      }
      ```
- **DELETE /api/v1/student/{id}**: Delete a student by ID
