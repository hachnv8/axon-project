package com.hacheery.productservice.core.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.common.aliasing.qual.Unique;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(unique = true, nullable = false)
    private String productId;

    private String title;
    private BigDecimal price;
    private Integer quantity;
}
