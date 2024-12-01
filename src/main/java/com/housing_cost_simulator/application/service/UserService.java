package com.housing_cost_simulator.application.service;

import com.housing_cost_simulator.application.dto.UserDto;
import com.housing_cost_simulator.application.mapper.UserMapper;
import com.housing_cost_simulator.domain.usecase.FindUserUseCase;
import com.housing_cost_simulator.domain.usecase.RegisterUserUsecase;
import com.housing_cost_simulator.entrypoint.dto.RegisterUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final FindUserUseCase findUserUseCase;
    private final UserMapper userMapper;
    private final RegisterUserUsecase registerUserUsecase;

    public UserDto findUserByEmail(String email) {
        return userMapper.userToUserDto(findUserUseCase.execute(email));
    }

    public void registerUser(RegisterUserRequest userRequest) {
        registerUserUsecase.execute(userRequest);
    }
}
