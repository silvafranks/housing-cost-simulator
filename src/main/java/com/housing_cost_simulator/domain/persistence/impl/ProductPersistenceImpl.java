package com.housing_cost_simulator.domain.persistence.impl;

import com.housing_cost_simulator.domain.model.entities.Product;
import com.housing_cost_simulator.domain.persistence.ProductPersistence;
import com.housing_cost_simulator.infrastructure.repository.mysql.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductPersistenceImpl implements ProductPersistence {

    private final ProductRepository productRepository;

    @Override
    public Product findByProductName(String name) {
        return productRepository.findByName(name).orElse(null);
    }
}
