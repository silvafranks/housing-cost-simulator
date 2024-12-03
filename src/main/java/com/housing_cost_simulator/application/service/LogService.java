package com.housing_cost_simulator.application.service;


import com.housing_cost_simulator.application.mapper.UserMapper;
import com.housing_cost_simulator.infrastructure.persistence.LogPersistence;
import com.housing_cost_simulator.entrypoint.dto.UserSearchCountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogPersistence logPersistence;
    private final UserMapper userMapper;

    public UserSearchCountDto getUserMostSearches() {
        return logPersistence.getUserMostSearches();
    }

}
