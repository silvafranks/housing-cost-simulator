package com.housing_cost_simulator.domain.persistence;

import com.housing_cost_simulator.domain.model.entities.User;

public interface UserPersistence {
    User findUserByEmail(String email);
    void saveUser(User user);
}
