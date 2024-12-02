package com.housing_cost_simulator.application.service;

import static com.housing_cost_simulator.application.validator.PriceValidator.isValid;

import com.housing_cost_simulator.application.dto.AddressDto;
import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.application.mapper.UserMapper;
import com.housing_cost_simulator.domain.model.entities.User;
import com.housing_cost_simulator.domain.persistence.UserPersistence;
import com.housing_cost_simulator.domain.usecase.CreatePriceUseCase;
import com.housing_cost_simulator.domain.usecase.RecoverLoggedUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final CreatePriceUseCase createPriceUseCase;
    private final AddressService addressService;
    private final UserMapper userMapper;
    private final RecoverLoggedUserUseCase recoverLoggedUserUseCase;
    private final UserPersistence userPersistence;

    public void createPrice(PriceDto priceDto) {
        isValid(priceDto);
        String cep = priceDto.getAddress().getCep();

        User userByEmail = userPersistence.findUserByEmail(
              recoverLoggedUserUseCase.getCurrentUser());

        AddressDto address = addressService.findAddressByCEP(cep,
              userMapper.userDtoToUser(userMapper.userToUserDto(userByEmail)));

        priceDto.setAddress(address);
        createPriceUseCase.execute(priceDto);
    }

}
