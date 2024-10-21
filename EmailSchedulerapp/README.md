# Spring Boot Email Scheduler Application

This application demonstrates the use of Spring Boot for sending emails using SMTP, with additional features such as scheduled email sending and database notifications.

## Features

- **Dependency Injection**: Utilizes constructor, setter, and field injection for managing dependencies.
- **Email Sending**: Sends emails via various SMTP services (e.g., SendGrid, Mailgun, SMTP2GO).
- **Database Integration**: Records email sending status in a MySQL database.
- **Email Scheduling**: Schedules email sending using Spring's `@Scheduled` annotation.
- **Error Handling**: Custom exception handling for email failures.

## Technologies Used

- Java 11
- Spring Boot
- Spring Scheduler
- Spring Data JPA
- MySQL
- Lombok

## Prerequisites

- JDK 11 or higher
- MySQL Server
- An SMTP service account (e.g., SendGrid, Mailgun, SMTP2GO)

## Getting Started

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/email-scheduler.git
   cd email-scheduler
