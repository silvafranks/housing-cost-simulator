package com.housing_cost_simulator.application.service;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import com.housing_cost_simulator.application.dto.AddressDto;
import com.housing_cost_simulator.application.mapper.AddressMapper;
import com.housing_cost_simulator.domain.model.entities.Address;
import com.housing_cost_simulator.domain.model.entities.User;
import com.housing_cost_simulator.domain.usecase.CreateAddressUseCase;
import com.housing_cost_simulator.domain.usecase.CreateLogUseCase;
import com.housing_cost_simulator.domain.usecase.FindAddressUseCase;
import com.housing_cost_simulator.infrastructure.api.dto.AddressResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final FindAddressUseCase findAddressUseCase;
    private final AddressMapper addressMapper;
    private final CreateLogUseCase createLogUseCase;
    private final CreateAddressUseCase createAddressUseCase;

    public AddressDto findAddressByCEP(String cep, User user) {
        if (isEmpty(cep)) {
            throw new RuntimeException();
        }

        AddressResponseDto execute = findAddressUseCase.execute(cep);
        createLogUseCase.execute(user, addressMapper.addressResponseToAddress(execute));
        return addressMapper.addressResponseToAddressDto(execute);
    }

    public void saveAddress(Address address) {
        createAddressUseCase.saveAddress(address);
    }

}
