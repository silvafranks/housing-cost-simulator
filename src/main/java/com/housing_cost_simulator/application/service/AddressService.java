package com.housing_cost_simulator.application.service;

import com.housing_cost_simulator.application.dto.AddressDto;
import com.housing_cost_simulator.application.mapper.AddressMapper;
import com.housing_cost_simulator.domain.usecase.FindAdressUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final FindAdressUseCase findAdressUseCase;
    private final AddressMapper addressMapper;

    public AddressDto findAddressByCEP(String cep) {
        // validate
        return addressMapper.AddressResponseToAdressDto(findAdressUseCase.execute(cep));
    }

}
