package com.housing_cost_simulator.application.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PriceDto {

    private BigDecimal value;

    private AddressDto address;

    private ProductDto product;

    private StoreDto store;

}
