package com.example.LibrarySystem.repository;

import com.example.LibrarySystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

