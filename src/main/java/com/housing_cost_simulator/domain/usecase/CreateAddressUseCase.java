package com.housing_cost_simulator.domain.usecase;

import com.housing_cost_simulator.domain.model.entities.Address;
import com.housing_cost_simulator.infrastructure.persistence.AddressPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAddressUseCase {

    private final AddressPersistence addressPersistence;

    public void saveAddress(Address address) {
        addressPersistence.saveAddress(address);
    }

}
