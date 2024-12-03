package com.housing_cost_simulator.infrastructure.persistence.adapter;

import com.housing_cost_simulator.domain.model.entities.Product;
import com.housing_cost_simulator.infrastructure.persistence.ProductPersistence;
import com.housing_cost_simulator.infrastructure.repository.mysql.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductPersistence {

    private final ProductRepository productRepository;

    @Override
    public Product findByProductName(String name) {
        return productRepository.findByName(name).orElse(null);
    }
}
