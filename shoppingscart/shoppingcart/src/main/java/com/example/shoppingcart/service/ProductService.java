package com.example.shoppingcart.service;

import com.example.shoppingcart.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service  // This annotation ensures Spring knows it's a service bean
public class ProductService {
    public ResponseEntity<?> getAllProducts() {
        return null;
    }

    public ResponseEntity<?> addProduct(Product product) {
        return null;
    }
}