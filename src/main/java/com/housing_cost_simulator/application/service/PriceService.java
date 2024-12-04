package com.housing_cost_simulator.application.service;

import static com.housing_cost_simulator.application.validator.PriceValidator.isValid;

import com.housing_cost_simulator.application.dto.AddressDto;
import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.application.dto.ProductDto;
import com.housing_cost_simulator.application.dto.UserDto;
import com.housing_cost_simulator.application.mapper.UserMapper;
import com.housing_cost_simulator.domain.usecase.CreateLogPriceUseCase;
import com.housing_cost_simulator.domain.usecase.CreatePriceUseCase;
import com.housing_cost_simulator.domain.usecase.FindLowestPricedProduct;
import com.housing_cost_simulator.domain.usecase.FindMostExpensiveProduct;
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
    private final FindLowestPricedProduct findLowestPricedProduct;
    private final FindMostExpensiveProduct findMostExpensiveProduct;
    private final CreateLogPriceUseCase createLogPriceUseCase;

    public void createPrice(PriceDto priceDto) {

        isValid(priceDto);


        AddressDto address = addressService.findAddressByCEP(priceDto.getAddress().getCep());

        priceDto.setAddress(address);

        createPriceUseCase.execute(priceDto);
    }

    public Map<String, PriceDto> findPriceByNeighbourhood(String productName) {

        createLogPriceUseCase.execute(
              this.buildPriceDto(productName)
        );
        return searchPriceByNeighbourhood.execute(productName);
    }

    private PriceDto buildPriceDto(String productName) {
        return PriceDto.builder()
              .product(ProductDto.builder()
                    .name(productName)
                    .build())
              .build();
    }

    public PriceDto findLowestPriceProduct(String productName) {
        PriceDto priceDto = findLowestPricedProduct.execute(productName);
        createLogPriceUseCase.execute(priceDto);
        return priceDto;
    }

    public PriceDto findMostExpensiveProduct(String productName) {
        PriceDto priceDto = findMostExpensiveProduct.execute(productName);
        createLogPriceUseCase.execute(priceDto);
        return priceDto;
    }

}
