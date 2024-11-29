package com.housing_cost_simulator.domain.usecase;

import com.housing_cost_simulator.application.validator.EmailValidator;
import com.housing_cost_simulator.domain.model.entities.Product;
import com.housing_cost_simulator.domain.model.entities.User;
import com.housing_cost_simulator.domain.persistence.ProductPersistence;
import com.housing_cost_simulator.domain.persistence.UserPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindProductUseCase {

    private final ProductPersistence productPersistence;

    public Product execute(String name) {
//        EmailValidator.isValid(email);
        return productPersistence.findByProductName(name);
    }
}
