# Ambulance Service Provider

## Overview

The Ambulance Service Provider is a robust web-based system designed to efficiently manage ambulance services,
 offering an intuitive interface for ambulance requests, real-time tracking, and comprehensive user management.

## 🚨 Key Features

- **Secure Authentication**: JWT-based login with role-based access control
- **Intelligent Ambulance Assignment**: Automated nearest-ambulance selection
- **Real-Time Tracking**: GPS-based ambulance location monitoring
- **Role-Specific Dashboards**: 
  - Admins manage users, ambulances, and requests
  - Users request and track ambulances
  - Drivers manage assigned requests

## 🏗️ System Architecture

### Enhanced 3-Tier Architecture with Microservices Potential

#### 1. Presentation Layer (Frontend)
- Framework: Thymeleaf with React/Vue.js Hybrid Approach
- Features:
  - Responsive design
  - Role-specific view components
  - Real-time notification integration

#### 2. Business Logic Layer (Backend)
- Technology: Spring Boot with Microservices Architecture
- Proposed Microservices:
  - User Management Service
  - Ambulance Tracking Service
  - Request Handling Service
  - Notification Service

#### 3. Data Layer
- Primary Database: PostgreSQL with Read Replicas
- Caching: Redis for performance optimization
- Database Sharding for horizontal scalability



# Ambulance Service Provider
## Database Schema

### User Table

| Column Name | Data Type | Constraints |
|------------|-----------|-------------|
| id | BIGINT | Primary Key, Auto Increment |
| name | VARCHAR(100) | NOT NULL |
| email | VARCHAR(150) | NOT NULL, UNIQUE |
| password | VARCHAR(255) | NOT NULL |
| role | ENUM('USER', 'ADMIN', 'DRIVER') | NOT NULL |
| phone_number | VARCHAR(15) | NULLABLE |
| created_at | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP |

### Ambulance Table

| Column Name | Data Type | Constraints |
|------------|-----------|-------------|
| id | BIGINT | Primary Key, Auto Increment |
| license_plate | VARCHAR(20) | NOT NULL, UNIQUE |
| driver_id | BIGINT | Foreign Key (User.id) |
| status | ENUM('AVAILABLE', 'BUSY') | DEFAULT 'AVAILABLE' |
| location | VARCHAR(255) | NULLABLE |

### Request Table

| Column Name | Data Type | Constraints |
|------------|-----------|-------------|
| id | BIGINT | Primary Key, Auto Increment |
| user_id | BIGINT | Foreign Key (User.id) |
| ambulance_id | BIGINT | Foreign Key (Ambulance.id) |
| status | ENUM('PENDING', 'COMPLETED', 'CANCELED') | DEFAULT 'PENDING' |
| pickup_location | VARCHAR(255) | NOT NULL |
| drop_location | VARCHAR(255) | NOT NULL |
| created_at | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP |

### Notification Table

| Column Name | Data Type | Constraints |
|------------|-----------|-------------|
| id | BIGINT | Primary Key, Auto Increment |
| user_id | BIGINT | Foreign Key (User.id) |
| message | TEXT | NOT NULL |
| sent_at | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP |


```
+-------------+       +---------------+
|    Users    |       |   Ambulances  |
+-------------+       +---------------+
| PK: id      |<----->| PK: id        |
| name        |       | license_plate |
| email       |       | driver_id     |
| role        |       | status        |
| phone       |       | location      |
+-------------+       +---------------+
       |                     |
       |                     |
       v                     v
+-------------+       +---------------+
|   Requests  |       | Notifications |
+-------------+       +---------------+
| PK: id      |       | PK: id        |
| user_id     |       | user_id       |
| ambulance_id|       | message       |
| status      |       | sent_at       |
| pickup_loc  |       +---------------+
| drop_loc    |
| created_at  |
+-------------+
```

### Ambulance Service Provider - Figma Design
```
├── Design System
│   ├── Colors
│   ├── Typography
│   ├── Icons
│   └── Illustrations
│
├── Components
│   ├── Buttons
│   │   ├── Primary Button
│   │   ├── Secondary Button
│   │   └── Danger Button
│   ├── Input Fields
│   ├── Dropdowns
│   ├── Cards
│   └── Modals
│
├── Pages
│   ├── Authentication
│   │   ├── Login
│   │   └── Registration
│   ├── User Flow
│   │   ├── Dashboard
│   │   ├── Request Ambulance
│   │   └── Request History
│   ├── Driver Flow
│   │   ├── Active Requests
│   │   └── Request Details
│   └── Admin Flow
│       ├── User Management
│       ├── Ambulance Tracking
│       └── Analytics
│
└── Interactions & Prototyping
    ├── Page Transitions
    ├── Micro-interactions
    └── Error States
```

### File File Structure

### ambulance-service-provider/
ambulance-service-provider/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/ambulanceserviceprovider/
│   │   │       ├── config/
│   │   │       │   ├── SecurityConfig.java
│   │   │       │   └── JwtTokenProvider.java
│   │   │       ├── controller/
│   │   │       │   ├── UserController.java
│   │   │       │   ├── AmbulanceController.java
│   │   │       │   └── RequestController.java
│   │   │       ├── dto/                 
│   │   │       │   ├── UserDto.java
│   │   │       │   └── RequestDto.java
│   │   │       ├── exception/
│   │   │       │   ├── GlobalExceptionHandler.java
│   │   │       │   └── ResourceNotFoundException.java
│   │   │       ├── model/
│   │   │       │   ├── User.java
│   │   │       │   ├── Ambulance.java
│   │   │       │   └── Request.java
│   │   │       ├── repository/
│   │   │       │   ├── UserRepository.java
│   │   │       │   ├── AmbulanceRepository.java
│   │   │       │   └── RequestRepository.java
│   │   │       ├── service/
│   │   │       │   ├── UserService.java
│   │   │       │   ├── AmbulanceService.java
│   │   │       │   └── RequestService.java
│   │   │       ├── util/
│   │   │       │   ├── EmailService.java
│   │   │       │   └── LocationTracker.java
│   │   │       └── AmbulanceServiceProviderApplication.java
│   │   ├── resources/
│   │   │   ├── templates/
│   │   │   │   ├── user/
│   │   │   │   │   ├── dashboard.html
│   │   │   │   │   └── request-form.html
│   │   │   │   ├── admin/
│   │   │   │   │   ├── user-management.html
│   │   │   │   │   └── dashboard.html
│   │   │   │   └── common/
│   │   │   │       ├── login.html
│   │   │   │       └── registration.html
│   │   │   ├── static/
│   │   │   │   ├── css/
│   │   │   │   ├── js/
│   │   │   │   └── images/
│   │   │   ├── application.properties
│   │   │   └── application-dev.properties  
│   │   └── resources/
│   └── test/
│       └── java/
│           └── com/ambulanceserviceprovider/
│               ├── controller/
│               ├── service/
│               ├── repository/
│               └── integration/
└── pom.xml

### 🔐 Security Enhancements

- Implement OAuth2 for additional authentication providers
- Add Multi-Factor Authentication
- Use bcrypt for password hashing
- Implement HTTPS everywhere
- Add IP-based rate limiting

## 🚀 Getting Started

### Prerequisites

- Java 21+
- Maven 3.8+
- PostgreSQL 13+
- Docker (optional but recommended)

### Installation Steps

1. Clone the repository
   ```bash
   git clone https://github.com/your-org/ambulance-service-provider.git
   Resources :https://www.loginradius.com/blog/
   cd ambulance-service-provider
   ```

3. Build and Run
   ```bash
   # Maven Build
   mvn clean install

   # Run Application
   mvn spring-boot:run

   # Docker Deployment
   docker-compose up --build
   ```

### 🧪 Testing

- Unit Tests: `mvn test`
- Integration Tests: `mvn verify`
- Coverage Report: `mvn jacoco:report`

## 🔍 Monitoring & Observability

- Integrate Prometheus for metrics
- Use Grafana for dashboards
- Implement distributed tracing with Jaeger
- Log aggregation with ELK Stack

## 📈 Scalability Considerations

- Containerization with Kubernetes
- Horizontal Pod Autoscaling
- Message Queues (RabbitMQ/Kafka) for request processing
- Load Balancing

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch
3. Commit changes
4. Push to the branch
5. Create a Pull Request