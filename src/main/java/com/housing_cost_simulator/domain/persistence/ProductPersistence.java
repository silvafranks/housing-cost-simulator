package com.housing_cost_simulator.domain.persistence;

import com.housing_cost_simulator.domain.model.entities.Product;

public interface ProductPersistence {

    Product findByProductName(String name);

}
