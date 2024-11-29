package com.housing_cost_simulator.application.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    @NonNull
    private String cep;

    private String street;

    private String complement;

    private String neighbohood;

    private String state;

    private String region;
}
