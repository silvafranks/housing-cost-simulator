package com.housing_cost_simulator.domain.persistence;

import com.housing_cost_simulator.domain.model.entities.Price;

public interface PricePersistence {
    void persist(Price domain);
}
