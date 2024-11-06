package com.example.electronicsstore.model;

public class ProductSummary {
    private Long id;
    private String name;
    private double price;

    public ProductSummary(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}