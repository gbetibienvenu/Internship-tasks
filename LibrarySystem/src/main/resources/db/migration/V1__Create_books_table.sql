-- V2__Add_sample_data.sql
INSERT INTO books (title, author, publisher, year, isbn, genre, available_copies, total_copies, description, location)
VALUES
    ('The Great Gatsby', 'F. Scott Fitzgerald', 'Scribner', 1925, '9780743273565', 'Fiction', 5, 10, 'A novel set in the Jazz Age.', 'Shelf 1A'),
    ('1984', 'George Orwell', 'Secker & Warburg', 1949, '9780451524935', 'Dystopian', 3, 8, 'A dystopian social science fiction novel.', 'Shelf 2B');
