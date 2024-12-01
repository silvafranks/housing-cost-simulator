package com.housing_cost_simulator.domain.persistence;

import com.housing_cost_simulator.domain.model.entities.Address;

public interface AddressPersistence {
    void saveAddress(Address address);
}
