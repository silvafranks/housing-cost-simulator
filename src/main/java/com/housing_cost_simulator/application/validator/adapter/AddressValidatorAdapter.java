package com.housing_cost_simulator.application.validator.adapter;

import com.housing_cost_simulator.application.dto.AddressDto;
import com.housing_cost_simulator.application.validator.AddressValidator;
import com.housing_cost_simulator.domain.exception.UnprocessableEntityException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressValidatorAdapter implements AddressValidator {

    @Override
    public void isValid(AddressDto address) {

        if (Objects.isNull(address)) {
            throw new UnprocessableEntityException("Address Cannot Be Null");
        }
    }
}
