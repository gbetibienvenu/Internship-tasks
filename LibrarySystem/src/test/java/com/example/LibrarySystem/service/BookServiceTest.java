package com.example.LibrarySystem.service;

import com.example.LibrarySystem.entity.Book;
import com.example.LibrarySystem.exception.BookNotFoundException;
import com.example.LibrarySystem.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book mockBook;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockBook = new Book(1L, "Test Book", "Test Author", "Test Publisher", 2023, "1234567890123", "Fiction", 5, 10, "A test book", "A1");
    }

    @Test
    void getAllBooks() {
        List<Book> books = new ArrayList<>();
        books.add(mockBook);

        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookService.getAllBooks();
        assertEquals(1, result.size());
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void getBookById() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(mockBook));

        Book result = bookService.getBookById(1L);
        assertNotNull(result);
        assertEquals("Test Book", result.getTitle());
        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    void getBookById_NotFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(BookNotFoundException.class, () -> bookService.getBookById(1L));
    }

    @Test
    void addBook() {
        when(bookRepository.save(mockBook)).thenReturn(mockBook);

        Book result = bookService.addBook(mockBook);
        assertEquals("Test Book", result.getTitle());
        verify(bookRepository, times(1)).save(mockBook);
    }

    @Test
    void deleteBook() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(mockBook));

        bookService.deleteBook(1L);
        verify(bookRepository, times(1)).delete(mockBook);
    }

    @Test
    void deleteBook_NotFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(BookNotFoundException.class, () -> bookService.deleteBook(1L));
    }
}
