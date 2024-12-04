package com.housing_cost_simulator.domain.usecase;

import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.application.mapper.PriceMapper;
import com.housing_cost_simulator.domain.model.entities.Price;
import com.housing_cost_simulator.infrastructure.persistence.PricePersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatePriceUseCase {

    private final PricePersistence pricePersistence;
    private final PriceMapper priceMapper;

    public void execute(Price price){
        pricePersistence.persist(price);
    }

}
