# Shopping Cart Application

Welcome to my Shopping Cart Application! This project is built with Spring Boot and provides user authentication, registration, and JWT-based login. It also includes APIs for managing users in a shopping cart system.

## Table of Contents
- [About](#about)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [File Structure](#file-structure)
- [Installation](#installation)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)

## About
This project is a simple shopping cart application designed for learning and internship purposes. It provides a secure authentication system using JWT tokens and offers basic endpoints for user registration, login, and authentication. The backend is built with Spring Boot, utilizing Java, Spring Security, and JPA (Java Persistence API) for database interactions.

## Features
- **User Registration**: Allows new users to register with a username and password
- **User Login**: Authenticates users and generates a JWT token for secure access
- **Password Encoding**: Passwords are encoded and securely stored using BCrypt
- **JWT Authentication**: Tokens are generated for successful logins and validated for protected resources
- **User Management**: CRUD operations for user-related features
- **Database**: Uses  MySQL/PostgreSQL for user data storage

## Technologies Used
- **Spring Boot**: Framework for building Java-based web applications
- **Spring Security**: Provides security features like authentication and authorization
- **JWT (JSON Web Token)**: For generating and validating tokens for authentication
- **JPA (Java Persistence API)**: ORM for interacting with the database
- **BCrypt**: For securely encoding passwords
- **Postman**: Used for API testing (with Postman collections provided)
- **Maven**: For project dependency management and build lifecycle

## File Structure
```
shopping-cart-backend/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── shoppingcart/
│   │   │               ├── controller/
│   │   │               │   
│   │   │               ├── dto/
│   │   │               │   
│   │   │               ├── model/
│   │   │               │  
│   │   │               ├── repository/
│   │   │               │   
│   │   │               ├── security/
│   │   │               │   
│   │   │               ├── service/
│   │   │               │   
│   │   │               └── ShoppingCartApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   │       └── templates/
│
├── test/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── shoppingcart/
│   │               ├── controller/
│   │               │   └── AuthControllerTest.java
│   │               ├── service/
│   │               │   └── AuthServiceTest.java
│   │               ├── repository/
│   │               │   └── UserRepositoryTest.java
│   │               └── ShoppingCartApplicationTests.java
│   └── resources/
│       └── postman/
│           └── shopping_cart_api_collection.json
│
├── .gitignore
├── LICENSE
├── README.md
├── pom.xml
└── target/
```

## Installation

### Prerequisites
- Java 23+
- Maven for dependency management and building the project
- IDE like IntelliJ IDEA
- Postman (for API testing)

### Steps to Run
1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/yourusername/shopping-cart.git
   ```

2. Navigate to the project directory:
   ```bash
   cd shopping-cart
   ```

3. Build and run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```

The application should be running on `http://localhost:8080`.

## API Endpoints

### Authentication

#### POST /api/auth/register
- Registers a new user
- Request body:
  ```json
  {
    "username": "johndoe",
    "password": "password123"
  }
  ```
- Response: 200 OK or 400 Bad Request if the username is already taken

#### POST /api/auth/login
- Logs in a user and generates a JWT token
- Request body:
  ```json
  {
    "username": "bienbien",
    "password": "bien123"
  }
  ```
- Response: 200 OK with `Bearer <token>` or 401 Unauthorized for invalid credentials

## Testing
The application includes unit and integration tests to ensure that it works as expected.

### Unit Tests
- **AuthControllerTest**: Tests for the AuthController API endpoints
- **AuthServiceTest**: Tests for the AuthService logic
- **UserRepositoryTest**: Tests for user database interactions

### Postman Testing
- **Postman Collection**: The `shopping_cart_api_collection.json` file contains a Postman collection with the necessary API requests for testing the application
- This collection must be import  into Postman to test the application endpoints

To run the tests using Maven:
```bash
mvn test
```
---
**Note**: This is final submission project.