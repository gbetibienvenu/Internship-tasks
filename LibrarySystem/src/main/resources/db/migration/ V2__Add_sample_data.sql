-- V1__Create_books_table.sql
CREATE TABLE IF NOT EXISTS books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publisher VARCHAR(100) NOT NULL,
    year INT NOT NULL,
    isbn VARCHAR(20),
    genre VARCHAR(100),
    available_copies INT NOT NULL,
    total_copies INT NOT NULL,
    description VARCHAR(500),
    location VARCHAR(50)
);
