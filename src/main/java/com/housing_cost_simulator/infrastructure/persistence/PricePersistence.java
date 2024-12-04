package com.housing_cost_simulator.infrastructure.persistence;

import com.housing_cost_simulator.domain.model.entities.Price;
import java.util.Map;

public interface PricePersistence {

    void persist(Price domain);
    Map<String, Price> searchLastPriceByNeighbourhood(String productName);
    Price findLowestPricePerProduct(String productName);
    Price findMostExpensiveProduct(String productName);
}
