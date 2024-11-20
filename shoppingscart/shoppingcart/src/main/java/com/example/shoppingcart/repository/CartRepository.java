package com.example.shoppingcart.repository;

import com.example.shoppingcart.model.CartItem;
import com.example.shoppingcart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUser(User user);
}

