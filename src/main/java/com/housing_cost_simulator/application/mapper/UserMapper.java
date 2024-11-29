package com.housing_cost_simulator.application.mapper;

import com.housing_cost_simulator.application.dto.UserDto;
import com.housing_cost_simulator.domain.model.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User userDtoToUser(UserDto dto);
    UserDto userToUserDto(User dto);

}
