package com.example.electronicsstore.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException ex, HttpServletRequest request) {
        String apiVersion = request.getHeader("X-API-VERSION");

        if ("v2".equals(apiVersion)) {
            // Version 2 specific response
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Product not found", ex.getMessage()));
        }

        // Default to version 1 response
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, HttpServletRequest request) {
        String apiVersion = request.getHeader("X-API-VERSION");

        if ("v2".equals(apiVersion)) {
            // Version 2 specific response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("An error occurred", ex.getMessage()));
        }

        // Default to version 1 response
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
    }
}