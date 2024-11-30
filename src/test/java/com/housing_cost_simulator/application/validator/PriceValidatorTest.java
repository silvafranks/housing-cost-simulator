package com.housing_cost_simulator.application.validator;

import static org.junit.jupiter.api.Assertions.*;

import com.housing_cost_simulator.application.dto.AddressDto;
import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.application.dto.ProductDto;
import com.housing_cost_simulator.application.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PriceValidatorTest {

    @Test
    void isValid_shouldPassWithValidData() {
        PriceDto priceDto = PriceDto.builder()
              .address(AddressDto.builder()
                    .cep("12345-678")
                    .street("Rua Principal")
                    .complement("Apartamento 101")
                    .neighbohood("Centro")
                    .state("SP")
                    .region("Sudeste")
                    .build())
              .creator(UserDto.builder()
                    .email("user@example.com")
                    .build())
              .product(ProductDto.builder()
                    .id(1L)
                    .name("Produto Teste")
                    .subtipo("Eletrônico")
                    .build())
              .build();

        assertDoesNotThrow(() -> PriceValidator.isValid(priceDto));
    }

    @Test
    void isValid_shouldThrowWhenAddressIsNull() {
        PriceDto priceDto = PriceDto.builder()
              .address(null)
              .creator(UserDto.builder()
                    .email("user@example.com")
                    .build())
              .product(ProductDto.builder()
                    .id(1L)
                    .name("Produto Teste")
                    .subtipo("Eletrônico")
                    .build())
              .build();

        RuntimeException exception = assertThrows(RuntimeException.class, () -> PriceValidator.isValid(priceDto));
        assert exception.getMessage().equals("price address must not be empty!");
    }

    @Test
    void isValid_shouldThrowWhenCreatorIsNull() {
        PriceDto priceDto = PriceDto.builder()
              .address(AddressDto.builder()
                    .cep("12345-678")
                    .street("Rua Principal")
                    .complement("Apartamento 101")
                    .neighbohood("Centro")
                    .state("SP")
                    .region("Sudeste")
                    .build())
              .creator(null)
              .product(ProductDto.builder()
                    .id(1L)
                    .name("Produto Teste")
                    .subtipo("Eletrônico")
                    .build())
              .build();

        RuntimeException exception = assertThrows(RuntimeException.class, () -> PriceValidator.isValid(priceDto));
        assert exception.getMessage().equals("Creator of a price cannot be empty");
    }

    @Test
    void isValid_shouldThrowWhenProductIsNull() {
        PriceDto priceDto = PriceDto.builder()
              .address(AddressDto.builder()
                    .cep("12345-678")
                    .street("Rua Principal")
                    .complement("Apartamento 101")
                    .neighbohood("Centro")
                    .state("SP")
                    .region("Sudeste")
                    .build())
              .creator(UserDto.builder()
                    .email("user@example.com")
                    .build())
              .product(null)
              .build();

        RuntimeException exception = assertThrows(RuntimeException.class, () -> PriceValidator.isValid(priceDto));
        assert exception.getMessage().equals("Product of a price cannot be empty");
    }
}