package com.housing_cost_simulator.domain.usecase;

import com.housing_cost_simulator.infrastructure.api.ApiMocha;
import com.housing_cost_simulator.infrastructure.api.dto.AddressResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAddressUseCase {

    private final ApiMocha mocha;

    public AddressResponseDto execute(String cep) {
        return mocha.getAddress(cep);
    }
}
