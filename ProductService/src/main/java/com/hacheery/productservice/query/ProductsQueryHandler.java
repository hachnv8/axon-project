package com.hacheery.productservice.query;

import com.hacheery.productservice.core.data.ProductEntity;
import com.hacheery.productservice.core.data.ProductRepository;
import com.hacheery.productservice.query.rest.ProductRestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductsQueryHandler {
    private final ProductRepository productRepository;

    public List<ProductRestModel> findProducts() {
        List<ProductRestModel> productsRest = new ArrayList<>();

        List<ProductEntity> storedProducts = productRepository.findAll();
        for (ProductEntity productEntity : storedProducts) {
            ProductRestModel productRestModel = new ProductRestModel();
            BeanUtils.copyProperties(productEntity, productRestModel);
            productsRest.add(productRestModel);
        }

        return productsRest;
    }
}
