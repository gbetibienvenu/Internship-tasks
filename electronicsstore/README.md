# 📦 Electronics and Electrical Store Application  

This project is developed as part of my **internship assignment** to demonstrate my skills in backend development using **Spring Boot** and **MySQL**. It covers key concepts such as layered architecture, exception handling, input validation, and test-driven development with **JUnit** and **Mockito**.

---

## 💡 Project Overview  

The **Electronics and Electrical Store** is a backend service that allows users to perform CRUD operations (Create, Read, Update, and Delete) on products. It provides RESTful APIs to manage product data, ensuring validation of inputs and proper handling of exceptions.

---

## 🛠️ Features  

- **Add, update, delete, and fetch products** using RESTful APIs.  
- **Input validation** to prevent invalid data entries.  
- **Exception handling** for user-friendly error responses.  
- **MySQL** database for data persistence.  
- **Layered architecture** (Controller, Service, Repository).  
- **Unit and Integration tests** using **JUnit** and **Mockito**.

---

## 📂 Project Structure  


---

## 🔧 Technologies and Dependencies  

- **Spring Boot Starter Web**: For building REST APIs  
- **Spring Boot Starter Data JPA**: To interact with MySQL  
- **MySQL Driver**: Database connector  
- **Spring Boot Starter Validation**: To validate input data  
- **Spring Boot Starter Test**: For testing the application  
- **JUnit 5**: Testing framework  
- **Mockito**: Mocking framework for tests  

---

## 📝 API Endpoints  

| HTTP Method | Endpoint             | Description                  |  
|-------------|----------------------|------------------------------|  
| `GET`       | `/api/products`      | Get all products             |  
| `GET`       | `/api/products/{id}` | Get a product by ID          |  
| `POST`      | `/api/products`      | Add a new product            |  
| `PUT`       | `/api/products/{id}` | Update an existing product   |  
| `DELETE`    | `/api/products/{id}` | Delete a product by ID       |  

---

## ⚙️ How to Set Up and Run  

### 1. Prerequisites  
- **Java 17** installed on your system  
- **Maven** installed and configured  
- **MySQL** installed and running

### 2. Clone the Repository  
```bash  
git clone https://github.com/your-username/electronicsstore.git  
cd electronicsstore  

###  🧩 Error Handling
The application uses a global exception handler to ensure proper responses:

400 Bad Request: For invalid input data
404 Not Found: When a product ID does not exist
500 Internal Server Error: For database-related errors

### 🏁 What I Learned
Through this project, I got hands-on experience in:

Setting up a Spring Boot project from scratch
Implementing CRUD operations using RESTful APIs
Handling exceptions centrally for better error management
Writing unit and integration tests with JUnit and Mockito
Managing MySQL database interactions using JPA
### 💡 How to Test the API
Use Postman or any other REST client to test the endpoints by sending requests to:


http://localhost:8080/api/products
### 📢 Conclusion
This project was a great opportunity to apply the knowledge I gained during this week reading material. It helped me understand the importance of well-structured code, testing, and efficient error handling in backend development.