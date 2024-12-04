package com.housing_cost_simulator.application.validator;

import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.domain.exception.UnprocessableEntityException;

import static java.util.Objects.isNull;

public class PriceValidator {
    public static void isValid(PriceDto dto){
        if (isNull(dto.getAddress())) {
            throw new UnprocessableEntityException("price address must not be empty!");
        }

        if (isNull(dto.getProduct())) {
            throw new UnprocessableEntityException("Product of a price cannot be empty");
        }
    }
}
