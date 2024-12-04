package com.housing_cost_simulator.infrastructure.persistence;

import com.housing_cost_simulator.domain.model.entities.LogPrice;
import com.housing_cost_simulator.entrypoint.dto.UserSearchCountDto;
import java.util.List;

public interface LogPricePersistence {

    void persist(LogPrice logPrice);

    List<UserSearchCountDto> findProductMoreRegistration();
}
