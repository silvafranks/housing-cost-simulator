package com.housing_cost_simulator.application.validator;

import com.housing_cost_simulator.application.dto.PriceDto;

public interface PriceValidator {
    void isValid(PriceDto priceDto);
}

