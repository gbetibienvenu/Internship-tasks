package com.BookShopFlexisaf.Project.service;

import com.BookShopFlexisaf.Project.entity.Book;
import com.BookShopFlexisaf.Project.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testCreateBook() {
        Book book = new Book(null, "Test Book", "Test Author", "123456", 10.99, null);
        when(bookRepository.save(book)).thenReturn(book);

        Book createdBook = bookService.createBook(book);

        assertNotNull(createdBook);
        assertEquals("Test Book", createdBook.getTitle());
    }

    @Test
    public void testUpdateBook() {
        Book existingBook = new Book(1L, "Old Book", "Old Author", "654321", 12.99, null);
        Book updatedBook = new Book(null, "Updated Book", "Updated Author", "123456", 15.99, null);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(existingBook));
        when(bookRepository.save(existingBook)).thenReturn(existingBook);

        Book result = bookService.updateBook(1L, updatedBook);

        assertNotNull(result);
        assertEquals("Updated Book", result.getTitle());
    }

    @Test
    public void testDeleteBook() {
        doNothing().when(bookRepository).deleteById(1L);

        bookService.deleteBook(1L);

        verify(bookRepository, times(1)).deleteById(1L);
    }
}