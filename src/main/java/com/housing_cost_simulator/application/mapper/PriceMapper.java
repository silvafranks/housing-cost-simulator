package com.housing_cost_simulator.application.mapper;

import com.housing_cost_simulator.application.dto.AddressDto;
import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.domain.model.entities.Address;
import com.housing_cost_simulator.domain.model.entities.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    Price priceDtoToPrice(PriceDto dto);

    @Mapping(target = "product.price", ignore = true)
    PriceDto priceToPriceDto(Price domain);

}
