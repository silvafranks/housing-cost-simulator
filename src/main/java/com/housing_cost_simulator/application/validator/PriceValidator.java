package com.housing_cost_simulator.application.validator;

import com.housing_cost_simulator.application.dto.PriceDto;
import static java.util.Objects.isNull;

public class PriceValidator {
    public static void isValid(PriceDto dto){
        if (isNull(dto.getAddress())) {
            throw new RuntimeException("price address must not be empty!");
        }

        if (isNull(dto.getProduct())) {
            throw new RuntimeException("Product of a price cannot be empty");
        }
    }
}
