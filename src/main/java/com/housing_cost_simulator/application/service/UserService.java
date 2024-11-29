package com.housing_cost_simulator.application.service;

import com.housing_cost_simulator.application.dto.UserDto;
import com.housing_cost_simulator.application.mapper.UserMapper;
import com.housing_cost_simulator.domain.usecase.FindUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final FindUserUseCase findUserUseCase;
    private final UserMapper userMapper;

    public UserDto findUserByEmail(String email) {
        return userMapper.userToUserDto(findUserUseCase.execute(email));
    }
}
