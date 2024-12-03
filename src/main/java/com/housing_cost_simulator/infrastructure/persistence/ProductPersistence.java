package com.housing_cost_simulator.infrastructure.persistence;

import com.housing_cost_simulator.domain.model.entities.Product;

public interface ProductPersistence {

    Product findByProductName(String name);

}
