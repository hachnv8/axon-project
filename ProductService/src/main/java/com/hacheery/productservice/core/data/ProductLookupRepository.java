package com.hacheery.productservice.core.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLookupRepository extends JpaRepository<ProductLookUpEntity, String> {
    ProductLookUpEntity findByProductIdOrTitle(String productId, String title);
}
