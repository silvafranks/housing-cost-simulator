package com.housing_cost_simulator.application.service;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import com.housing_cost_simulator.application.dto.AddressDto;
import com.housing_cost_simulator.application.mapper.AddressMapper;
import com.housing_cost_simulator.domain.model.entities.User;
import com.housing_cost_simulator.domain.usecase.CreateLogUseCase;
import com.housing_cost_simulator.domain.usecase.FindAdressUseCase;
import com.housing_cost_simulator.infrastructure.api.dto.AddressResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final FindAdressUseCase findAdressUseCase;
    private final AddressMapper addressMapper;
    private final CreateLogUseCase createLogUseCase;

    public AddressDto findAddressByCEP(String cep, User user) {
        if (isEmpty(cep)) {
            throw new RuntimeException();
        }

        AddressResponseDto execute = findAdressUseCase.execute(cep);
        createLogUseCase.execute(user, addressMapper.addressResponseToAddress(execute));
        return addressMapper.addressResponseToAdressDto(execute);
    }

}
