package com.housing_cost_simulator.application.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.housing_cost_simulator.application.dto.AddressDto;
import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.application.dto.ProductDto;
import com.housing_cost_simulator.application.validator.adapter.PriceValidatorAdapter;
import com.housing_cost_simulator.domain.exception.UnprocessableEntityException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PriceValidatorTest {


    PriceValidator priceValidator = new PriceValidatorAdapter();

    @Test
    void isValid_shouldPassWithValidData() {
        PriceDto priceDto = PriceDto.builder()
              .address(AddressDto.builder()
                    .cep("12345-678")
                    .street("Rua Principal")
                    .complement("Apartamento 101")
                    .neighborhood("Centro")
                    .state("SP")
                    .region("Sudeste")
                    .build())
              .product(ProductDto.builder()
                    .id(1L)
                    .name("Produto Teste")
                    .subtype("Eletrônico")
                    .build())
              .build();

        assertDoesNotThrow(() -> priceValidator.isValid(priceDto));
    }

    @Test
    void isValid_shouldThrowWhenAddressIsNull() {
        PriceDto priceDto = PriceDto.builder()
              .address(null)
              .product(ProductDto.builder()
                    .id(1L)
                    .name("Produto Teste")
                    .subtype("Eletrônico")
                    .build())
              .build();

        UnprocessableEntityException exception = assertThrows(UnprocessableEntityException.class,
              () -> priceValidator.isValid(priceDto));
        assert exception.getMessage().equals("price address must not be empty!");
    }

    @Test
    void isValid_shouldThrowWhenProductIsNull() {
        PriceDto priceDto = PriceDto.builder()
              .address(AddressDto.builder()
                    .cep("12345-678")
                    .street("Rua Principal")
                    .complement("Apartamento 101")
                    .neighborhood("Centro")
                    .state("SP")
                    .region("Sudeste")
                    .build())
              .product(null)
              .build();

        UnprocessableEntityException exception = assertThrows(UnprocessableEntityException.class,
              () -> priceValidator.isValid(priceDto));
        assert exception.getMessage().equals("Product of a price cannot be empty");
    }
}