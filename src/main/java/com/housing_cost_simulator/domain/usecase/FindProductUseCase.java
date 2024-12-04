package com.housing_cost_simulator.domain.usecase;

import com.housing_cost_simulator.domain.model.entities.Product;
import com.housing_cost_simulator.infrastructure.persistence.ProductPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindProductUseCase {

    private final ProductPersistence productPersistence;

    public Product execute(String name) {
        return productPersistence.findByProductName(name);
    }
}
