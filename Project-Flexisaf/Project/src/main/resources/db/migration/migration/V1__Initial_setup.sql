-- Create Category table
CREATE TABLE category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Create Book table
CREATE TABLE book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(255) UNIQUE,
    price DECIMAL(10, 2),
    category_id BIGINT,
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category(id)
);

-- This script ensures that the database is created if it does not exist
DO $$
BEGIN
   IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'electronics_store') THEN
       PERFORM dblink_connect('dbname=postgres user=postgres password=Bienvenu6676@');
       PERFORM dblink_exec('CREATE DATABASE electronics_store');
   END IF;
END;
$$;

