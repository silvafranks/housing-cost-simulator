package com.housing_cost_simulator.entrypoint.dto;

import com.housing_cost_simulator.application.dto.AddressDto;
import com.housing_cost_simulator.application.dto.ProductDto;
import com.housing_cost_simulator.application.dto.StoreDto;
import com.housing_cost_simulator.application.dto.UserDto;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceWithMoreRecords {

    private BigDecimal value;

    private AddressDto address;

    private ProductDto product;

    private StoreDto store;

    private UserDto userDto;
}
