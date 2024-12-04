package com.housing_cost_simulator.application.service;


import com.housing_cost_simulator.infrastructure.persistence.LogPersistence;
import com.housing_cost_simulator.entrypoint.dto.UserSearchCountDto;
import com.housing_cost_simulator.infrastructure.persistence.LogPricePersistence;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogPersistence logPersistence;
    private final LogPricePersistence logPricePersistence;

    public UserSearchCountDto getUserMostSearches() {
        return logPersistence.getUserMostSearches();
    }
    public List<UserSearchCountDto> getProductMostSearches() {
        return logPricePersistence.findProductMoreRegistration();
    }


}
