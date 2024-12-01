package com.housing_cost_simulator.domain.usecase;

import com.housing_cost_simulator.application.validator.EmailValidator;
import com.housing_cost_simulator.domain.model.entities.User;
import com.housing_cost_simulator.domain.persistence.UserPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindUserUseCase {

    private final UserPersistence userPersistence;

    public User execute(String email) {
        EmailValidator.isValid(email);
        return userPersistence.findUserByEmail(email);
    }

}
