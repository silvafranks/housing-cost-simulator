package com.housing_cost_simulator.domain.usecase;

import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.infrastructure.persistence.PricePersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindLowestPricedProduct {

    private final PricePersistence pricePersistence;

    public PriceDto execute(String productName){
       return pricePersistence.findLowestPricePerProduct(productName);
    }

}
