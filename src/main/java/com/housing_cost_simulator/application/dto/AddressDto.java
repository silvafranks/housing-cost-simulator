package com.housing_cost_simulator.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {

    @NonNull
    private String cep;

    private String street;

    private String complement;

    private String neighborhood;

    private String state;

    private String region;
}
