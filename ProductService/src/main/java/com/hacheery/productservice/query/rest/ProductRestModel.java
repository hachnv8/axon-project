package com.hacheery.productservice.query.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRestModel {
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
