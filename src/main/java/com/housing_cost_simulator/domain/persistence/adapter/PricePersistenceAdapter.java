package com.housing_cost_simulator.domain.persistence.adapter;

import com.housing_cost_simulator.domain.model.entities.Price;
import com.housing_cost_simulator.domain.model.entities.Product;
import com.housing_cost_simulator.domain.model.entities.User;
import com.housing_cost_simulator.domain.persistence.PricePersistence;
import com.housing_cost_simulator.domain.usecase.RecoverLoggedUserUseCase;
import com.housing_cost_simulator.infrastructure.repository.mysql.PriceRepository;
import com.housing_cost_simulator.infrastructure.repository.mysql.ProductRepository;
import com.housing_cost_simulator.infrastructure.repository.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PricePersistenceAdapter implements PricePersistence {

    private final PriceRepository priceRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final RecoverLoggedUserUseCase recoverLoggedUserUseCase;

    @Override
    public void persist(Price domain) {
        String emailUser = recoverLoggedUserUseCase.getCurrentUser();

        User create = userRepository.findByEmail(emailUser)
              .orElseThrow(() -> new UsernameNotFoundException(
                    "User not found with username: " + emailUser));

        Product product = productRepository.findByName(domain.getProduct().getName())
              .orElseGet(() -> {
                  Product newProduct = domain.getProduct();
                  newProduct.setCreator(create);
                  return productRepository.save(newProduct);
              });

        domain.setCreator(create);
        domain.setProduct(product);

        priceRepository.save(domain);
    }
}
