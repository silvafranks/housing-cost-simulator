package com.housing_cost_simulator.application.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {

    private Long id;

    private String name;

    private String subtipo;

    private UserDto creator;

    private List<PriceDto> price;

}
