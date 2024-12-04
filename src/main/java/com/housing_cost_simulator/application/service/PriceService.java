package com.housing_cost_simulator.application.service;


import com.housing_cost_simulator.application.dto.AddressDto;
import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.application.dto.ProductDto;
import com.housing_cost_simulator.application.mapper.PriceMapper;
import com.housing_cost_simulator.application.validator.PriceValidator;
import com.housing_cost_simulator.domain.model.entities.Price;
import com.housing_cost_simulator.domain.usecase.CreateLogPriceUseCase;
import com.housing_cost_simulator.domain.usecase.CreatePriceUseCase;
import com.housing_cost_simulator.domain.usecase.FindLowestPricedProduct;
import com.housing_cost_simulator.domain.usecase.FindMostExpensiveProduct;
import com.housing_cost_simulator.domain.usecase.SearchPriceByNeighbourhood;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final CreatePriceUseCase createPriceUseCase;
    private final AddressService addressService;
    private final SearchPriceByNeighbourhood searchPriceByNeighbourhood;
    private final FindLowestPricedProduct findLowestPricedProduct;
    private final FindMostExpensiveProduct findMostExpensiveProduct;
    private final CreateLogPriceUseCase createLogPriceUseCase;
    private final PriceValidator priceValidator;
    private final PriceMapper priceMapper;

    public void createPrice(PriceDto priceDto) {

        priceValidator.isValid(priceDto);

        AddressDto address = addressService.findAddressByCEP(priceDto.getAddress().getCep());

        priceDto.setAddress(address);

        createPriceUseCase.execute(priceMapper.priceDtoToPrice(priceDto));
    }

    public Map<String, PriceDto> findPriceByNeighbourhood(String productName) {

        createLogPriceUseCase.execute(
              priceMapper.priceDtoToPrice(this.buildPriceDto(productName))
        );
        return convertToPriceDto(searchPriceByNeighbourhood.execute(productName));
    }

    private Map<String, PriceDto> convertToPriceDto(Map<String, Price> priceMap) {
        return priceMap.entrySet().stream()
              .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> priceMapper.priceToPriceDto(entry.getValue())
              ));
    }

    private PriceDto buildPriceDto(String productName) {
        return PriceDto.builder()
              .product(ProductDto.builder()
                    .name(productName)
                    .build())
              .build();
    }

    public PriceDto findLowestPriceProduct(String productName) {
        Price priceDomain = findLowestPricedProduct.execute(productName);
        createLogPriceUseCase.execute(priceDomain);
        return priceMapper.priceToPriceDto(priceDomain);
    }

    public PriceDto findMostExpensiveProduct(String productName) {
        Price priceDto = findMostExpensiveProduct.execute(productName);
        createLogPriceUseCase.execute(priceDto);
        return priceMapper.priceToPriceDto(priceDto);
    }

}
