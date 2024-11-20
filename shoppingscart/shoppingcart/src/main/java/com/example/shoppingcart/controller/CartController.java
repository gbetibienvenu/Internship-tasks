package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.CartItem;
import com.example.shoppingcart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody CartItem cartItem) {
        return cartService.addToCart(cartItem);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeFromCart(@PathVariable Long id) {
        return cartService.removeFromCart(id);
    }

    @GetMapping
    public ResponseEntity<?> getCart() {
        return cartService.getCart();
    }
}
