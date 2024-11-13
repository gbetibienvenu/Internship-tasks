package com.BookShopFlexisaf.Project.service;

import com.BookShopFlexisaf.Project.repository.BookRepository;
import com.BookShopFlexisaf.Project.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByCategory(Long categoryId) {
        return bookRepository.findByCategoryId(categoryId);  // Call custom repository method to filter by category
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPrice(book.getPrice());
            existingBook.setIsbn(book.getIsbn());
            existingBook.setCategory(book.getCategory());
            return bookRepository.save(existingBook);
        } else {
            throw new RuntimeException("Book not found");
        }
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}





//package com.BookShopFlexisaf.Project.service;
//
//import com.BookShopFlexisaf.Project.repository.BookRepository;
//import com.BookShopFlexisaf.Project.entity.Book;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class BookService {
//
//   //  private final BookRepository bookRepository;
//
//    public List<Book> getAllBooks() {
//        return bookRepository.findAll();
//    }
//
//    public Book createBook(Book book) {
//        return bookRepository.save(book);
//    }
//
//    public Book updateBook(Long id, Book book) {
//        Optional<Book> optionalBook = bookRepository.findById(id);
//        if (optionalBook.isPresent()) {
//            Book existingBook = optionalBook.get();
//            existingBook.setTitle(book.getTitle());
//            existingBook.setAuthor(book.getAuthor());
//            existingBook.setPrice(book.getPrice());
//            existingBook.setIsbn(book.getIsbn());
//            existingBook.setCategory(book.getCategory());
//            return bookRepository.save(existingBook);
//        } else {
//            throw new RuntimeException("Book not found");
//        }
//    }
//    public void deleteBook(Long id) {
//        bookRepository.deleteById(id);
//    }
//}