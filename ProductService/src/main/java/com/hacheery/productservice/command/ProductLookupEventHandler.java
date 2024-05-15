package com.hacheery.productservice.command;

import com.hacheery.productservice.core.data.ProductLookUpEntity;
import com.hacheery.productservice.core.data.ProductLookupRepository;
import com.hacheery.productservice.core.events.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ProcessingGroup("product-group")
public class ProductLookupEventHandler {
    private final ProductLookupRepository productLookupRepository;

    @EventHandler
    public void on(ProductCreatedEvent event) {
        ProductLookUpEntity productLookUpEntity = new ProductLookUpEntity(
                event.getProductId(),
                event.getTitle()
        );

        productLookupRepository.save(productLookUpEntity);
    }
}
