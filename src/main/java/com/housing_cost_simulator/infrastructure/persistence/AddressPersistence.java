package com.housing_cost_simulator.infrastructure.persistence;

import com.housing_cost_simulator.domain.model.entities.Address;

public interface AddressPersistence {
    void saveAddress(Address address);
}
