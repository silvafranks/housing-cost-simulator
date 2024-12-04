package com.housing_cost_simulator.infrastructure.persistence;

import com.housing_cost_simulator.domain.model.entities.Log;
import com.housing_cost_simulator.domain.model.entities.LogPrice;

public interface LogPricePersistence {

    void persist(LogPrice logPrice);

    LogPrice findProductMoreRegistration();
}
