package com.example.electronicsstore.controller;

import com.example.electronicsstore.model.Product;
import com.example.electronicsstore.model.ProductSummary;
import com.example.electronicsstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequest;  // Updated import
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    private String getApiVersion(HttpServletRequest request) {
        return request.getHeader("X-API-VERSION");
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts(HttpServletRequest request) {
        String apiVersion = getApiVersion(request);

        List<Product> products = productService.getAllProducts();
        if ("v2".equals(apiVersion)) {
            // Return a version-specific format for v2
            List<EntityModel<Product>> productModels = products.stream()
                    .map(product -> EntityModel.of(product,
                            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getProductById(product.getId(), request)).withSelfRel(),
                            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getAllProducts(request)).withRel("all-products"),
                            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getProductSummary(product.getId())).withRel("product-summary")))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(productModels);
        }

        // Default to v1 format
        List<EntityModel<Product>> productModels = products.stream()
                .map(product -> EntityModel.of(product,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getProductById(product.getId(), request)).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getAllProducts(request)).withRel("all-products")))
                .collect(Collectors.toList());
        return ResponseEntity.ok(productModels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id, HttpServletRequest request) {
        String apiVersion = getApiVersion(request);
        Product product = productService.getProductById(id);

        if ("v2".equals(apiVersion)) {
            // Return a custom response for v2 (more details or structured differently)
            return ResponseEntity.ok(EntityModel.of(product,
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getProductById(id, request)).withSelfRel(),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getAllProducts(request)).withRel("all-products"),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getProductSummary(id)).withRel("product-summary")));
        }

        // Default to v1 format
        return ResponseEntity.ok(EntityModel.of(product,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getProductById(id, request)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getAllProducts(request)).withRel("all-products")));
    }

    @GetMapping("/summary/{id}")
    public EntityModel<ProductSummary> getProductSummary(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        ProductSummary summary = new ProductSummary(product.getId(), product.getName(), product.getPrice());
        return EntityModel.of(summary,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getProductSummary(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getAllProducts(null)).withRel("all-products"));
    }
    // Endpoints for create, update, and delete remain the same
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}