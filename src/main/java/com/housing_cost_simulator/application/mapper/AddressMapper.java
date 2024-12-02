package com.housing_cost_simulator.application.mapper;

import com.housing_cost_simulator.application.dto.AddressDto;
import com.housing_cost_simulator.domain.model.entities.Address;
import com.housing_cost_simulator.infrastructure.api.dto.AddressResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDto addressResponseToAddressDto(AddressResponseDto responseDto);
    Address addressResponseToAddress(AddressResponseDto responseDto);
    Address addressDtoToAddress(AddressDto addressDto);
}
