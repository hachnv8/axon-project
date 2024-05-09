package com.hacheery.productservice.command.rest;

import com.hacheery.productservice.command.CreateProductCommand;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductCommandController {
    private final CommandGateway commandGateway;

    @PostMapping
    public String createProduct(@Valid @RequestBody CreateProductRestModel model) {
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

    @PutMapping
    public String updateProduct() {
        return "Product updated";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "Product deleted";
    }
}
