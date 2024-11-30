package com.housing_cost_simulator.domain.persistence;

import com.housing_cost_simulator.domain.model.entities.Log;
import com.housing_cost_simulator.domain.model.entities.User;
import com.housing_cost_simulator.entrypoint.dto.UserSearchCountDto;

public interface LogPersistence {
    void persist(Log log);
    UserSearchCountDto getUserMostSearches();
}
