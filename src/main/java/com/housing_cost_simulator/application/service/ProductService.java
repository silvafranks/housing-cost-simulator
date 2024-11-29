package com.housing_cost_simulator.application.service;

import com.housing_cost_simulator.application.dto.ProductDto;
import com.housing_cost_simulator.application.mapper.ProductMapper;
import com.housing_cost_simulator.domain.model.entities.Product;
import com.housing_cost_simulator.domain.usecase.FindProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final FindProductUseCase findProductUseCase;
    private final ProductMapper productMapper;


    public ProductDto findByProductName(String name) {

        return productMapper.produtoToProdutoDto(findProductUseCase.execute(name));
    }

}