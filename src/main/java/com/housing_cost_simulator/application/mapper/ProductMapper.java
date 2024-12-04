package com.housing_cost_simulator.application.mapper;

import com.housing_cost_simulator.application.dto.ProductDto;
import com.housing_cost_simulator.domain.model.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "price", ignore = true)
    ProductDto produtoToProdutoDto(Product domain);

    @Mapping(target = "price", ignore = true)
    Product produtoDtoToProduto(ProductDto domain);
}
