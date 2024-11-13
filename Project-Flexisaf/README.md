# BookShop Flexisaf Project - Test Cases

This repository contains the test cases for the **BookShop Flexisaf** project, which implements a book management system. The tests cover key components of the system such as the **BookController**, **CategoryController**, **BookService**, and **CategoryService**. The purpose of these tests is to verify that the application's core functionalities are working as expected.

## Features

- **Book Management**: Ability to create, update, retrieve, and delete books.
- **Category Management**: Ability to create and delete book categories.
- **Mocking Services**: Use of `Mockito` to mock services and repositories.
- **Spring Boot Integration**: Use of Spring Boot's testing framework with `MockMvc` for controller testing.

## Table of Contents

- [Features](#features)
- [Test Cases](#test-cases)
  - [BookControllerTest](#bookcontrollertest)
  - [CategoryControllerTest](#categorycontrollertest)
  - [BookServiceTest](#bookservicetest)
  - [CategoryServiceTest](#categoryservicetest)
- [Dependencies](#dependencies)
- [Running Tests](#running-tests)

## Test Cases

### BookControllerTest
Tests the controller endpoints for managing books.
- **`testGetAllBooks`**: Verifies that the API returns a list of books.
- **`testCreateBook`**: Tests the book creation API.
- **`testUpdateBook`**: Tests the book update functionality.
- **`testDeleteBook`**: Verifies that the book deletion API works.

### CategoryControllerTest
Tests the controller endpoints for managing categories.
- **`testGetAllCategories`**: Verifies that the API returns a list of categories.
- **`testCreateCategory`**: Tests the category creation API.
- **`testDeleteCategory`**: Verifies that the category deletion API works.

### BookServiceTest
Tests the service methods for handling books.
- **`testCreateBook`**: Verifies that a new book is created correctly.
- **`testUpdateBook`**: Verifies that an existing book can be updated.
- **`testDeleteBook`**: Verifies that the book deletion method works.

### CategoryServiceTest
Tests the service methods for handling categories.
- **`testCreateCategory`**: Verifies that a new category is created correctly.
- **`testDeleteCategory`**: Verifies that a category can be deleted.

## Dependencies

To run the tests in this project, the following dependencies are required:

### Project Dependencies:
- **Spring Boot**: Framework for building Java-based applications.
- **Mockito**: Mocking framework for unit tests.
- **Spring Test**: To integrate Spring’s testing framework.
- **JUnit 5**: Testing framework used for running unit tests.
- **Jackson**: Used for serializing objects to JSON and vice versa.

### Maven Dependencies:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
</dependency>
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <scope>test</scope>
</dependency>
