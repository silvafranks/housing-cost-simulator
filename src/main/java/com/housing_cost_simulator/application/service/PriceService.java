package com.housing_cost_simulator.application.service;

import static com.housing_cost_simulator.application.validator.PriceValidator.isValid;

import com.housing_cost_simulator.application.dto.AddressDto;
import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.application.mapper.UserMapper;
import com.housing_cost_simulator.domain.usecase.CreatePriceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final CreatePriceUseCase createPriceUseCase;
    private final AddressService addressService;
    private final UserMapper userMapper;

    public void createPrice(PriceDto priceDto) {
        isValid(priceDto);
        String cep = priceDto.getAddress().getCep();

        AddressDto address = addressService.findAddressByCEP(cep,
              userMapper.userDtoToUser(priceDto.getCreator()));
        priceDto.setAddress(address);
        createPriceUseCase.execute(priceDto);
    }

}
