# Library Management System

## Project Overview
The Library Management System is a Spring Boot application designed to facilitate the management of library books. It allows users to perform various operations such as adding, updating, deleting, and viewing books in the library. This project aims to demonstrate the use of Spring Boot, JPA (Java Persistence API), and MySQL as the database to create a functional and user-friendly library management application.

## Table of Contents
1. [Entity Fields](#entity-fields)
2. [Git and GitHub Commands Guide](#git-and-github-commands-guide)

---

## Entity Fields

### Book Entity
The `Book` entity represents a book in the library system. Below are the fields included in the entity, along with their descriptions:

| Field Name        | Description                                                                                                                                     |
|-------------------|-------------------------------------------------------------------------------------------------------------------------------------------------|
| `title`           | The title of the book. It represents the main name under which the book is published.                                                         |
| `author`          | The author of the book. This field captures the person or entity who wrote the book.                                                          |
| `isbn`            | A unique identifier for books, known as the International Standard Book Number. This ensures that each book can be distinctly recognized.     |
| `publisher`       | The company or entity that published the book, providing information about where the book was produced.                                        |
| `publicationDate` | The date when the book was published, allowing users to see when the book was released.                                                       |
| `category`        | The genre or category of the book, such as fiction, non-fiction, fantasy, etc. This helps in organizing and searching for books by genre.     |
| `pages`           | The number of pages in the book. This field provides users with an idea of the length of the book.                                            |
| `language`        | The language in which the book is written, indicating the language for reading the book.                                                      |
| `copiesAvailable` | The number of copies available for borrowing, informing users how many copies they can check out from the library.                             |
| `location`        | The shelf or section where the book is stored in the library, which helps users find the book in the physical library space.                   |

---

## Git and GitHub Commands Guide

### Creating a Repository
**Command:** `git init`  
**Description:** Initializes a new Git repository in your project directory.  
**Example:**
- Create a new directory: `mkdir my-project`
- Change into the directory: `cd my-project`
- Initialize Git: `git init`

### Cloning a Repository
**Command:** `git clone <repository-url>`  
**Description:** Clones a remote repository to your local machine, creating a local copy of the repository.  
**Example:** 
- `git clone https://github.com/gbetibienvenu/repository.git`

### Creating Branches
**Command:** `git branch <branch-name>`  
**Description:** Creates a new branch in your repository to facilitate separate development lines.  
**Example:** 
- `git branch feature-branch`

### Committing Changes
**Commands:**
- `git add <file-name>`
- `git commit -m "Your commit message"`  
**Description:** 
- The `git add` command stages your changes.
- The `git commit` command creates a commit with a message explaining the changes.  
**Example:** 
- `git add README.md`
- `git commit -m "Add README file"`

### Reverting Commits
**Command:** `git revert <commit-hash>`  
**Description:** Reverts a specific commit and creates a new commit that undoes the changes made by the specified commit.  
**Example:** 
- `git revert absd1233`

### Pulling and Pushing Changes
**Commands:**
- `git pull origin <branch-name>`
- `git push origin <branch-name>`  
**Description:** 
- `git pull` fetches and merges changes from the remote repository.
- `git push` sends your local changes to the remote repository.  
**Example:** 
- `git pull origin main`
- `git push origin main`

### Fetching Changes
**Command:** `git fetch`  
**Description:** Retrieves changes from the remote repository without merging them into your current branch.  
**Example:** 
- `git fetch origin`

### Merging Branches
**Command:** `git merge <branch-name>`  
**Description:** Merges changes from one branch into another, typically from a feature branch into the main branch.  
**Example:** 
- `git merge feature-branch`

### Renaming Branches
**Command:** `git branch -m <new-branch-name>`  
**Description:** Renames the current branch to a new name, allowing for better clarity in branch naming.  
**Example:** 
- `git branch -m new-branch-name`

### Creating Pull Requests
**Description:** Pull requests can be created via the GitHub interface. Navigate to your repository, switch to your feature branch, and click on "New Pull Request."

### Reviewing and Merging Pull Requests
**Description:** Once a pull request is made, it can be reviewed and merged using the GitHub web interface. Collaborators can provide feedback or approve the changes.

### Reverting Pull Requests
**Command:** `git revert -m 1 <merge-commit-hash>`  
**Description:** Reverts a merged pull request by providing the commit hash of the merged pull request, effectively undoing the changes made by the pull request.  
**Example:** 
- `git revert -m 1 hashnumberhere`

---

# Conclusion
This README file provides a comprehensive guide to the Library Management System project, detailing the essential fields used in the book entity and a list of key Git and GitHub commands. This structure is aimed at helping users understand both the application functionality and the version control processes involved in managing the project.




  # THIS IS WEEK 5 TASK UPDATED BELOW

# 📚  Library Management System
This project is a Library Management System built with Spring Boot. It leverages Flyway to manage database versioning and migrations, ensuring smooth schema changes and consistent setup across multiple environments.

# 🗂️ Project Structure
plaintext
Copy code
src  
└── main  
    └── resources  
        └── db  
            └── migration  
                ├── v1_create_books_table.sql  
                └── v2_add_sample_data.sql  
# ⚙️ Flyway Configuration
The following Flyway settings are added to application.properties to enable and control database migrations:

# properties
Copy code
spring.flyway.enabled=true  
spring.flyway.baseline-on-migrate=true  
spring.flyway.locations=classpath:db/migration  
Configuration Details:
Command: spring.flyway.enabled=true
Description: Activates Flyway on application startup.

Command: spring.flyway.baseline-on-migrate=true
Description: Ensures migrations run even if the schema isn't empty.

Command: spring.flyway.locations=classpath:db/migration
Description: Specifies the location of migration scripts.

# 📝 Database Migration Scripts
The db/migration folder contains the following SQL migration scripts:

1. v1_create_books_table.sql
Description: Creates the books table to store information about books in the library.

2. v2_add_sample_data.sql
Description: Inserts initial sample data into the books table for testing and demonstration.

# 🚀 How to Run the Application
Follow these steps to run the Library Management System:

1. Clone the Repository:
bash
Copy code
git clone <your-repository-url>  
cd <your-project-directory>  
2. Ensure Dependencies are Installed:
Java 17  or higher
Maven
3. Configure the Database:
Update the application.properties file with your database connection settings, if necessary.
4. Run the Application:
bash
Copy code
mvn spring-boot:run  
5. Flyway Migration:
Command: Flyway
Description: Flyway will automatically apply all migration scripts from the db/migration folder during startup.

# ✨ Features
Manage Books: Add, update, and delete book records.
Database Versioning: Flyway ensures consistent schema management across multiple environments.
Pre-loaded Data: The application includes sample data for quick testing and demonstration.

## Testing 
# This are the  outlines,for  the testing  of the existing  LibrarySystem application.  It  focuses  specifically on the BookController and BookService components.

## Table of Contents
# Introduction
# Testing Structure
# Dependencies
# Annotations and Setup
# Test Overview
# Running the Tests
# Introduction


BookController Integration Tests: Tests the BookController endpoints using mock services, ensuring correct API responses.
BookService Unit Tests: Tests the logic of BookService, ensuring correct behavior with a mocked repository.
The goal is to ensure all parts of the book management functionality work as expected, including listing, retrieving, adding, and deleting books.

Testing Structure
The test files are organized as follows:



src
└── test
    └── java
        └── com
            └── example
                └── LibrarySystem
                    ├── controller
                    │   └── BookControllerTest.java
                    ├── service
                    │   └── BookServiceTest.java

# 1. BookControllerTest (Integration Test)
The BookControllerTest class, located in controller/BookControllerTest.java, tests the controller layer. Using MockMvc and MockBean, this test suite ensures the BookController methods correctly handle HTTP requests.

# 2. BookServiceTest (Unit Test)
The BookServiceTest class, located in service/BookServiceTest.java, tests the business logic in BookService. It mocks the BookRepository to isolate and validate the service’s behavior independently of the data access layer.

# Dependencies
You can run these tests, include the following dependencies in your pom.xml:


<dependencies>
    <!-- Spring Boot Starter Test -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>

    <!-- Mockito Core -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <scope>test</scope>
    </dependency>

    <!-- Mockito JUnit Jupiter -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-junit-jupiter</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>

# https://central.sonatype.com/artifact/org.mockito/mockito-core?smo=true
# https://mvnrepository.com/artifact/org.mockito/mockito-core

Annotations and Setup
Each test class uses specific annotations to configure the test environment:

@WebMvcTest: It used in BookControllerTest to set up a Spring MVC context, isolating controller behavior.
@MockBean: It creates a mock instance of BookService in the BookControllerTest, replacing the actual service implementation.
@Mock and @InjectMocks: Used in BookServiceTest to inject mock dependencies into the BookService.
@BeforeEach: Sets up mock data before each test to ensure consistent test conditions.
Test Overview
BookControllerTest (Integration Tests)
The BookControllerTest class tests the API endpoints in BookController using MockMvc for HTTP request simulation:

getAllBooks: Tests the GET /api/books endpoint, checking that it returns the correct JSON response for a list of books.
getBookById: Tests retrieving a book by ID using GET /api/books/{id}, ensuring the correct book data is returned.
addBook: Verifies that POST /api/books correctly adds a new book and returns the expected data in the response.
deleteBook: Confirms that DELETE /api/books/{id} works as expected and returns the appropriate status code.
BookServiceTest (Unit Tests)
The BookServiceTest class tests the business logic in BookService:

getAllBooks: Ensures that the findAll method of the BookRepository is called and returns a list of books.
getBookById: Tests fetching a book by ID, verifying correct book data is returned and handling the case where the book is not found.
addBook: Verifies that a new book can be saved to the repository successfully.
deleteBook: Confirms deletion of an existing book and verifies the correct behavior when attempting to delete a non-existing book.
Running the Tests
To execute the tests, you can use the following commands:

# Run all tests
mvn test

# Run specific test classes
mvn -Dtest=BookControllerTest test
mvn -Dtest=BookServiceTest test

# 📖 Conclusion
This Library Management System offers a reliable starting point for managing book records. With Flyway seamlessly handling schema changes, developers can focus on extending the system’s features without worrying about database inconsistencies.












