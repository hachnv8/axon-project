package com.hacheery.productservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final Environment environment;

    @PostMapping
    public String createProduct() {
        return "Product created";
    }

    @GetMapping
    public String getProducts() {
        return "Product list" + environment.getProperty("local.server.port");
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
