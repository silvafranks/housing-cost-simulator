package com.housing_cost_simulator.domain.usecase;

import com.housing_cost_simulator.application.dto.ProductDto;
import com.housing_cost_simulator.application.mapper.ProductMapper;
import com.housing_cost_simulator.domain.model.entities.Product;
import com.housing_cost_simulator.domain.model.entities.User;
import com.housing_cost_simulator.infrastructure.persistence.ProductPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateProductUseCase {

    private final ProductPersistence productPersistence;
    private final RecoverLoggedUserUseCase recoverLoggedUserUseCase;
    private final FindUserUseCase findUserUseCase;
    private final CreateLogUseCase createLogUseCase;
    private final ProductMapper productMapper;

    public void execute(ProductDto productDto) {
        Product product = productMapper.produtoDtoToProduto(productDto);
        User userRecovered = findUserUseCase.execute(recoverLoggedUserUseCase.getCurrentUser());
        product.setCreator(userRecovered);
        createLogUseCase.execute(userRecovered, null);
        productPersistence.persist(product);
    }

}
