package com.housing_cost_simulator.domain.usecase;

import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.domain.model.entities.Price;
import com.housing_cost_simulator.infrastructure.persistence.PricePersistence;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SearchPriceByNeighbourhood {

    private final PricePersistence pricePersistence;

    public Map<String, Price> execute(String productName) {

        return pricePersistence.searchLastPriceByNeighbourhood(productName);
    }


}
