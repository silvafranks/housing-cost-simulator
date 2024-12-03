package com.housing_cost_simulator.infrastructure.persistence;

import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.domain.model.entities.Price;
import java.util.Map;

public interface PricePersistence {

    void persist(Price domain);

    Map<String, PriceDto> searchLastPriceByNeighbourhood(String productName);
}
