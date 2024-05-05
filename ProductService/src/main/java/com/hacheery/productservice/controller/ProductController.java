package com.hacheery.productservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @PostMapping
    public String createProduct() {
        return "Product created";
    }

    @GetMapping
    public String getProducts() {
        return "Product list";
    }

    @PutMapping
    public String updateProduct() {
        return "Product updated";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "Product deleted";
    }
}
