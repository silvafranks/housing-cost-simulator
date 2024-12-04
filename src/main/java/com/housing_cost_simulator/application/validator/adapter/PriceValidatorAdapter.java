package com.housing_cost_simulator.application.validator.adapter;

import static java.util.Objects.isNull;

import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.application.validator.PriceValidator;
import com.housing_cost_simulator.domain.exception.UnprocessableEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PriceValidatorAdapter implements PriceValidator {

    @Override
    public void isValid(PriceDto dto) {
        if (isNull(dto.getAddress())) {
            throw new UnprocessableEntityException("price address must not be empty!");
        }

        if (isNull(dto.getProduct())) {
            throw new UnprocessableEntityException("Product of a price cannot be empty");
        }
    }
}
