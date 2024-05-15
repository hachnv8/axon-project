package com.hacheery.productservice.core.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@Table(name = "productlookup")
@NoArgsConstructor
@AllArgsConstructor
public class ProductLookUpEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String productId;

    @Column(unique = true)
    private String title;
}
