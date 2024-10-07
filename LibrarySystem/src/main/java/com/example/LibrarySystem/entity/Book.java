package com.example.LibrarySystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.ISBN;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 100, message = "Title cannot exceed 100 characters")
    @Column(length = 100, nullable = false)
    private String title;

    @NotBlank(message = "Author is mandatory")
    @Size(max = 100, message = "Author name cannot exceed 100 characters")
    @Column(length = 100, nullable = false)
    private String author;

    @NotBlank(message = "Publisher is mandatory")
    @Size(max = 100, message = "Publisher name cannot exceed 100 characters")
    @Column(length = 100, nullable = false)
    private String publisher;

    @NotNull(message = "Publication year is required")
    @Column(nullable = false)
    private Integer year;

    @ISBN(message = "Please provide a valid ISBN")
    @Size(max = 20, message = "ISBN cannot exceed 20 characters")
    @Column(length = 20)
    private String isbn;

    @Size(max = 100, message = "Genre cannot exceed 100 characters")
    @Column(length = 100)
    private String genre;

    @NotNull(message = "Available copies are required")
    @Column(nullable = false)
    private Integer availableCopies;

    @NotNull(message = "Total copies are required")
    @Column(nullable = false)
    private Integer totalCopies;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    @Column(length = 500)
    private String description;

    @Size(max = 50, message = "Location should not exceed 50 characters")
    @Column(name = "location", length = 50)
    private String location; // e.g., Shelf number or room
}

