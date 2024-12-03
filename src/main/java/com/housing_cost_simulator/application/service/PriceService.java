package com.housing_cost_simulator.application.service;

import static com.housing_cost_simulator.application.validator.PriceValidator.isValid;

import com.housing_cost_simulator.application.dto.AddressDto;
import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.application.mapper.UserMapper;
import com.housing_cost_simulator.domain.model.entities.User;
import com.housing_cost_simulator.domain.usecase.CreatePriceUseCase;
import com.housing_cost_simulator.domain.usecase.RecoverLoggedUserUseCase;
import com.housing_cost_simulator.domain.usecase.SearchPriceByNeighbourhood;
import com.housing_cost_simulator.infrastructure.persistence.UserPersistence;
import java.util.Map;
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
    private final SearchPriceByNeighbourhood searchPriceByNeighbourhood;

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

    public Map<String, PriceDto> findPriceByNeighbourhood(String productName) {
        return searchPriceByNeighbourhood.execute(productName);
    }

}
