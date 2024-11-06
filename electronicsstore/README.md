# 📦 Electronics and Electrical Store Application
This project was developed as part of my internship assignment to demonstrate my skills in backend development using Spring Boot and MySQL.
 It covers key concepts such as layered architecture, exception handling, input validation, API versioning, 
 and test-driven development with JUnit and Mockito.

# 💡 Project Overview
The Electronics and Electrical Store is a backend service that allows users to perform CRUD operations 
(Create, Read, Update, and Delete) on products. It provides RESTful APIs to manage product data, 
ensuring validation of inputs and proper handling of exceptions. The API also supports versioning, 
allowing for future enhancements with backward compatibility.

 # 🛠️ Features
Add, update, delete, and fetch products using RESTful APIs.
Input validation to prevent invalid data entries.
Exception handling for user-friendly error responses.
API Versioning using the X-API-VERSION header for different resource formats.
MySQL database for data persistence.
Layered architecture (Controller, Service, Repository).
Unit and Integration tests using JUnit and Mockito.
Enhanced error responses in different versions.
# 📂 Project Structure
**The project follows a layered architecture:**
 
**Controller: Manages incoming HTTP requests and API versioning.**
Service: Contains business logic and processes data between the controller and repository layers.
Repository: Interfaces with the MySQL database for data persistence.
Exception Handling: A global exception handler provides consistent error responses across the API.

# 🔧 Technologies and Dependencies
Spring Boot Starter Web: For building REST APIs
Spring Boot Starter Data JPA: To interact with MySQL
MySQL Driver: Database connector
Spring Boot Starter Validation: To validate input data
Spring Boot Starter Test: For testing the application
JUnit 5: Testing framework
Mockito: Mocking framework for tests

# 📝 API Endpoints
HTTP Method	Endpoint	Description
GET	/api/products	Get all products
GET	/api/products/{id}	Get a product by ID
POST	/api/products	Add a new product
PUT	/api/products/{id}	Update an existing product
DELETE	/api/products/{id}	Delete a product by ID
GET	/api/products/summary/{id}	Get product summary (v2 only)
Versioning via X-API-VERSION Header
To retrieve different resource representations based on version, include the X-API-VERSION header in your requests.

# Example:

v1: Standard product details
v2: Additional ProductSummary response with simplified product information
http


GET /api/products HTTP/1.1
Host: localhost:8080
X-API-VERSION: v2
# ⚙️ How to Set Up and Run
1. Prerequisites
Java 23 installed on your system
Maven installed and configured
MySQL installed and running
2. Clone the Repository


# git clone https://github.com/your-username/electronicsstore.git  
cd electronicsstore  
3. Set Up the Database
Create a MySQL database named electronics_store and update the application.properties file with your MySQL credentials.

4. Run the Application

mvn spring-boot:run  
5. Test the API
Use Postman or any other REST client to test the endpoints by sending requests to:

http://localhost:8080/api/products

# 🧩 Error Handling
The application uses a global exception handler to ensure proper responses:

400 Bad Request: For invalid input data
404 Not Found: When a product ID does not exist
500 Internal Server Error: For database-related errors
Error responses differ based on API versions. Version v2 provides enhanced error detail.

# 🏁 What I Learned
**Through this project, I gained hands-on experience in:**

Setting up a Spring Boot project from scratch
Implementing CRUD operations using RESTful APIs
Handling exceptions centrally for better error management
Writing unit and integration tests with JUnit and Mockito
Managing MySQL database interactions using JPA
Implementing API versioning for backward compatibility and enhanced feature support
Structuring error responses for improved user experience across API versions
# 📢 Conclusion
This project was a valuable opportunity to deepen my knowledge in backend development. 
The integration of versioning, layered architecture, and testing underscored the importance of well-structured code, 
efficient error handling, and user-focused design in API development.