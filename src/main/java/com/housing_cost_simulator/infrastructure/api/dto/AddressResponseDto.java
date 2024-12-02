package com.housing_cost_simulator.infrastructure.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponseDto {

    private String cep;

    private String street;

    private String complement;

    private String neighborhood;

    private String state;

    private String region;
}
