package com.housing_cost_simulator.domain.usecase;

import com.housing_cost_simulator.application.dto.ProductDto;
import com.housing_cost_simulator.application.mapper.ProductMapper;
import com.housing_cost_simulator.domain.exception.UnprocessableEntityException;
import com.housing_cost_simulator.domain.model.entities.Product;
import com.housing_cost_simulator.domain.model.entities.User;
import com.housing_cost_simulator.infrastructure.persistence.ProductPersistence;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateProductUseCase {

    private final ProductPersistence productPersistence;
    private final RecoverLoggedUserUseCase recoverLoggedUserUseCase;
    private final FindUserUseCase findUserUseCase;
    private final CreateLogUseCase createLogUseCase;

    public void execute(Product product) {
        Product productName = productPersistence.findByProductName(product.getName());

        if (Objects.nonNull(productName)) {
            throw new UnprocessableEntityException("Product already exists!");
        }

        User userRecovered = findUserUseCase.execute(recoverLoggedUserUseCase.getCurrentUser());
        product.setCreator(userRecovered);
        createLogUseCase.execute(userRecovered, null);
        productPersistence.persist(product);
    }

}
