package com.housing_cost_simulator.infrastructure.persistence.adapter;

import com.housing_cost_simulator.domain.model.entities.User;
import com.housing_cost_simulator.infrastructure.persistence.UserPersistence;
import com.housing_cost_simulator.infrastructure.repository.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistence {

    private final UserRepository userRepository;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
