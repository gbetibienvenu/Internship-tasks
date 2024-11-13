package com.example.LibrarySystem.controller;

import com.example.LibrarySystem.entity.Book;
import com.example.LibrarySystem.exception.BookNotFoundException;
import com.example.LibrarySystem.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    private Book mockBook;

    @BeforeEach
    void setUp() {
        mockBook = new Book(1L, "Test Book", "Test Author", "Test Publisher", 2023, "1234567890123", "Fiction", 5, 10, "A test book", "A1");
    }

    @Test
    void getAllBooks() throws Exception {
        when(bookService.getAllBooks()).thenReturn(Arrays.asList(mockBook));

        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Test Book"));
        verify(bookService, times(1)).getAllBooks();
    }

    @Test
    void getBookById() throws Exception {
        when(bookService.getBookById(1L)).thenReturn(mockBook);

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Book"));
        verify(bookService, times(1)).getBookById(1L);
    }

    @Test
    void addBook() throws Exception {
        when(bookService.addBook(any(Book.class))).thenReturn(mockBook);

        String bookJson = "{\"title\":\"Test Book\",\"author\":\"Test Author\",\"publisher\":\"Test Publisher\",\"year\":2023,\"isbn\":\"1234567890123\",\"genre\":\"Fiction\",\"availableCopies\":5,\"totalCopies\":10,\"description\":\"A test book\",\"location\":\"A1\"}";

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Book"));
        verify(bookService, times(1)).addBook(any(Book.class));
    }

    @Test
    void deleteBook() throws Exception {
        doNothing().when(bookService).deleteBook(1L);

        mockMvc.perform(delete("/api/books/1"))
                .andExpect(status().isOk());
        verify(bookService, times(1)).deleteBook(1L);
    }
}

