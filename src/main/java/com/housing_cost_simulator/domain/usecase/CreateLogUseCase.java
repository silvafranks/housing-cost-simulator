package com.housing_cost_simulator.domain.usecase;

import com.housing_cost_simulator.domain.model.entities.Address;
import com.housing_cost_simulator.domain.model.entities.Log;
import com.housing_cost_simulator.domain.model.entities.User;
import com.housing_cost_simulator.domain.persistence.LogPersistence;
import com.housing_cost_simulator.infrastructure.api.dto.AddressResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateLogUseCase {

    private final LogPersistence logPersistence;

    public void execute(User user, Address address) {
        Log log = new Log();
        log.setAddress(address);
        log.setUser(user);
        logPersistence.persist(log);
    }
}
