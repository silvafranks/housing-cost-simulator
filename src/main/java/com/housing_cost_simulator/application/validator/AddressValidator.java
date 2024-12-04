package com.housing_cost_simulator.application.validator;

import com.housing_cost_simulator.application.dto.AddressDto;

public interface AddressValidator {

    void isValid(AddressDto address);
}
