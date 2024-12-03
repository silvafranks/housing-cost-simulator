package com.housing_cost_simulator.infrastructure.persistence.adapter;

import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.application.mapper.PriceMapper;
import com.housing_cost_simulator.domain.model.entities.Price;
import com.housing_cost_simulator.domain.model.entities.Product;
import com.housing_cost_simulator.domain.model.entities.User;
import com.housing_cost_simulator.domain.usecase.RecoverLoggedUserUseCase;
import com.housing_cost_simulator.infrastructure.persistence.PricePersistence;
import com.housing_cost_simulator.infrastructure.repository.mysql.PriceRepository;
import com.housing_cost_simulator.infrastructure.repository.mysql.ProductRepository;
import com.housing_cost_simulator.infrastructure.repository.mysql.UserRepository;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
    private final PriceMapper priceMapper;

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

    @Override
    public Map<String, PriceDto> searchLastPriceByNeighbourhood(String productName) {
        List<Price> latestPriceByProductAndNeighborhoodNative = priceRepository.findByProduct_Name(
              productName);

        return this.getLatestPricesByNeighborhood(latestPriceByProductAndNeighborhoodNative);
    }

    private Map<String, PriceDto> getLatestPricesByNeighborhood(List<Price> prices) {

        return prices.stream()
              .collect(Collectors.groupingBy(
                    p -> p.getAddress().getNeighborhood(),
                    Collectors.collectingAndThen(
                          Collectors.maxBy(Comparator.comparing(Price::getCreated)),
                          opt -> opt.map(priceMapper::priceToPriceDto).orElse(null)
                    )
              ));
    }

}
