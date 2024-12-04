package com.housing_cost_simulator.infrastructure.persistence.adapter;

import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.application.mapper.PriceMapper;
import com.housing_cost_simulator.domain.exception.UnprocessableEntityException;
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
    public Map<String, Price> searchLastPriceByNeighbourhood(String productName) {
        return this.getLatestPricesByNeighborhood(priceRepository.findByProduct_Name(
              productName));
    }
    private Map<String, PriceDto> convertToPriceDto(Map<String, Price> priceMap) {
        return priceMap.entrySet().stream()
              .collect(Collectors.toMap(
                    Map.Entry::getKey, // A chave continua a mesma
                    entry -> priceMapper.priceToPriceDto(entry.getValue()) // Converte o valor para DTO
              ));
    }


    @Override
    public Price findLowestPricePerProduct(String productName) {
        List<Price> priceByProduct = priceRepository.findByProduct_Name(productName);

        if (priceByProduct.isEmpty()) {
            throw new UnprocessableEntityException("There is no such product");
        }

        return priceByProduct.stream().min(Comparator.comparing(Price::getValue))
              .orElseThrow();
    }

    @Override
    public Price findMostExpensiveProduct(String productName) {
        List<Price> productByName = priceRepository.findByProduct_Name(productName);
        return productByName.stream().max(Comparator.comparing(Price::getValue))
              .orElseThrow();
    }

    private Map<String, Price> getLatestPricesByNeighborhood(List<Price> prices) {
        return prices.stream()
              .collect(Collectors.groupingBy(
                    p -> p.getAddress().getNeighborhood(),
                    Collectors.collectingAndThen(
                          Collectors.maxBy(Comparator.comparing(Price::getCreated)),
                          opt -> opt.orElse(null)
                    )
              ));
    }

}
