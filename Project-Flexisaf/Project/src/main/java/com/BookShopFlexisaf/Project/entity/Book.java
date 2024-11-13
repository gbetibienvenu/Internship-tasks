package com.BookShopFlexisaf.Project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;

    @Column(unique = true)
    private String isbn;

    private double price;

    @ManyToOne(fetch = FetchType.LAZY) // Use LAZY to avoid unnecessary loading
    @JoinColumn(name = "category_id", nullable = false) // This will set up the foreign key to Category
    private Category category;
}