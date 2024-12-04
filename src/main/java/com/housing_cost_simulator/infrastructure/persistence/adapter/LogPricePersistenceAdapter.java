package com.housing_cost_simulator.infrastructure.persistence.adapter;

import com.housing_cost_simulator.domain.model.entities.LogPrice;
import com.housing_cost_simulator.infrastructure.persistence.LogPricePersistence;
import com.housing_cost_simulator.infrastructure.repository.mongo.LogPriceRepository;
import com.housing_cost_simulator.infrastructure.repository.mongo.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogPricePersistenceAdapter implements LogPricePersistence {

    private final LogPriceRepository logPriceRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public void persist(LogPrice logPrice) {
        logPriceRepository.save(logPrice);
    }

    @Override
    public LogPrice findProductMoreRegistration() {
        return null;
    }
}
