package com.housing_cost_simulator.application.mapper;

import com.housing_cost_simulator.application.dto.ProductDto;
import com.housing_cost_simulator.domain.model.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto produtoToProdutoDto(Product domain);
}
