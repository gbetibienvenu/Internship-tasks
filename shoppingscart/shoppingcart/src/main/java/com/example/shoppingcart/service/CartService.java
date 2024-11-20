package com.example.shoppingcart.service;

import com.example.shoppingcart.model.CartItem;
import com.example.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public ResponseEntity<?> addToCart(CartItem cartItem) {
        CartItem savedItem = cartRepository.save(cartItem);
        return ResponseEntity.ok(savedItem);
    }

    public ResponseEntity<?> removeFromCart(Long id) {
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
            return ResponseEntity.ok("Item removed successfully.");
        } else {
            return ResponseEntity.badRequest().body("Item not found.");
        }
    }

    public ResponseEntity<List<CartItem>> getCart() {
        List<CartItem> cartItems = cartRepository.findAll();
        return ResponseEntity.ok(cartItems);
    }
}