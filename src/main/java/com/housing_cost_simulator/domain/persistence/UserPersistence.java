package com.housing_cost_simulator.domain.persistence;

import com.housing_cost_simulator.domain.model.entities.User;
import java.util.List;

public interface UserPersistence {
    User findByEmail(String email);
}
