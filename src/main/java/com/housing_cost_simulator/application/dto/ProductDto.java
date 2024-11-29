package com.housing_cost_simulator.application.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long id;

    private String name;

    private String subtipo;

    private UserDto creator;

    private List<PriceDto> price;

}
