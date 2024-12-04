package com.housing_cost_simulator.infrastructure.persistence;

import com.housing_cost_simulator.domain.model.entities.LogPrice;
import com.housing_cost_simulator.entrypoint.dto.ProductAndRegistrationQuantity;
import java.util.List;

public interface LogPricePersistence {

    void persist(LogPrice logPrice);

    List<ProductAndRegistrationQuantity> findProductMoreRegistration();
}
