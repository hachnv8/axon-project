package com.hacheery.productservice.controller;

import com.hacheery.productservice.command.CreateProductCommand;
import com.hacheery.productservice.rest.CreateProductRestModel;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final Environment environment;// dùng để quản lý cấu hình ứng dụng trong các file properties, yaml,..
    private final CommandGateway commandGateway;

    @PostMapping
    public String createProduct(@RequestBody CreateProductRestModel model) {
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(model.getPrice())
                .quantity(model.getQuantity())
                .title(model.getTitle())
                .productId(UUID.randomUUID().toString())
                .build();
        String returnValue;
        try {
            returnValue = commandGateway.sendAndWait(createProductCommand);
        } catch (Exception e) {
            returnValue = e.getLocalizedMessage();
        }
        return returnValue;
    }

    @GetMapping
    public String getProducts() {
        return "Product list " + environment.getProperty("local.server.port");
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
