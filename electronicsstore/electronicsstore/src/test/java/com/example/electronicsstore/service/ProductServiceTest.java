package com.example.electronicsstore.service;

import com.example.electronicsstore.exception.ProductNotFoundException;
import com.example.electronicsstore.model.Product;
import com.example.electronicsstore.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product("Laptop", 1500, "Electronics");
        product.setId(1L);
    }

    @Test
    public void testGetAllProducts() {
        when(productRepository.findAll()).thenReturn(List.of(product));
        List<Product> products = productService.getAllProducts();
        assertEquals(1, products.size(), "Product list size should be 1");
        assertEquals("Laptop", products.get(0).getName(), "Product name should match");
        verify(productRepository, times(1)).findAll(); // Verify that the repository was queried exactly once
    }

    @Test
    public void testGetProductById_Success() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Product foundProduct = productService.getProductById(1L);
        assertNotNull(foundProduct, "Product should not be null");
        assertEquals("Laptop", foundProduct.getName(), "Product name should match");
    }

    @Test
    public void testGetProductById_NotFound() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ProductNotFoundException.class, () -> productService.getProductById(1L),
                "Expected exception not thrown when product not found");
    }

    @Test
    public void testCreateProduct() {
        when(productRepository.save(product)).thenReturn(product);
        Product createdProduct = productService.createProduct(product);
        assertEquals("Laptop", createdProduct.getName(), "Product name should match");
        verify(productRepository, times(1)).save(product); // Verify that the save method was called exactly once
    }

    @Test
    public void testDeleteProduct() {
        doNothing().when(productRepository).deleteById(1L);
        productService.deleteProduct(1L);
        verify(productRepository, times(1)).deleteById(1L); // Ensure that delete was called
    }
}