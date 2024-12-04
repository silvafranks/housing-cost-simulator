package com.housing_cost_simulator.application.validator;

import com.housing_cost_simulator.domain.exception.UnprocessableEntityException;
import com.housing_cost_simulator.domain.model.entities.Address;
import java.util.Objects;

public class AddressValidator {

    public static void isValid(Address address) {

        if (Objects.isNull(address)) {
            throw new UnprocessableEntityException("Address Cannot Be Null");
        }

    }
}
