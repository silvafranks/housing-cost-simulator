package com.housing_cost_simulator.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreDto {

    private Long id;

    private UserDto creator;

    private AddressDto address;
}
