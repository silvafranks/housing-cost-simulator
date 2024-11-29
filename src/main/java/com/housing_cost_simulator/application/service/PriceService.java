package com.housing_cost_simulator.application.service;

import static com.housing_cost_simulator.application.validator.PriceValidator.isValid;

import com.housing_cost_simulator.application.dto.AddressDto;
import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.application.dto.ProductDto;
import com.housing_cost_simulator.application.dto.UserDto;
import com.housing_cost_simulator.domain.model.entities.User;
import com.housing_cost_simulator.domain.usecase.CreatePriceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final CreatePriceUseCase createPriceUseCase;
    private final AddressService addressService;
    private final ProductService productService;
    private final UserService userService;

    public void createPrice(PriceDto priceDto) {
        isValid(priceDto);
        AddressDto address = addressService.findAddressByCEP(priceDto.getAddress().getCep());
        priceDto.setAddress(address);
        createPriceUseCase.execute(priceDto);
    }

}
