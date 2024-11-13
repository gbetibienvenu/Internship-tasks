# Spring Boot Email Scheduler Application

This application demonstrates the use of Spring Boot for sending emails using SMTP, with additional features such as scheduled email sending and database notifications.

## Features

- **Dependency Injection**: Utilizes constructor, setter, and field injection for managing dependencies.
- **Email Sending**: Sends emails via various SMTP services (e.g., SendGrid, Mailgun, SMTP2GO).
- **Database Integration**: Records email sending status in a MySQL database.
- **Email Scheduling**: Schedules email sending using Spring's `@Scheduled` annotation.
- **Error Handling**: Custom exception handling for email failures.

## Technologies Used

- Java 23
- Spring Boot
- Spring Scheduler
- Spring Data JPA
- MySQL
- Lombok

## Prerequisites

- JDK 11 or higher
- MySQL Server
- An SMTP service account (e.g., SendGrid, Mailgun, SMTP2GO)



# Email Scheduler Application - Testing Guide

This repository contains the email scheduling application, including the service and controller layers for handling email sending functionalities. The application uses Spring Boot for backend implementation, and the testing is done using JUnit and Mockito to simulate and verify the expected behavior of email sending.

## Project Structure

- **Controller Layer**: Manages HTTP requests related to email operations.
  - `EmailController.java`: Handles API requests for sending emails.

- **Service Layer**: Contains business logic for sending emails.
  - `EmailService.java`: Defines the logic for sending emails and logging them.
  
- **Entity Layer**: Defines entities related to email operations.
  - `EmailLog.java`: Represents the log of sent emails.
  
- **Repository Layer**: Interacts with the database for email logs.
  - `EmailLogRepository.java`: Manages CRUD operations for `EmailLog`.

- **Test Layer**: Contains unit and integration tests for the application.
  - `EmailControllerTest.java`: Tests the HTTP endpoints in the controller layer.
  - `EmailServiceTest.java`: Tests the business logic in the service layer.

## Technologies Used

- **Spring Boot**: The framework for building the backend service.
- **JUnit 5**: Used for writing and running tests.
- **Mockito**: Used for mocking dependencies in unit tests.
- **Spring Test**: Used for integration testing of the controller layer.
- **JavaMailSender**: Used for sending emails in the service layer.

## The tools

- **JDK 23**: Required to run the Spring Boot application.
- **Maven**: For building and managing dependencies.
- **JUnit 5**: For unit testing.
- **Mockito**: For mocking dependencies in unit tests.

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-repo/email-scheduler-app.git


