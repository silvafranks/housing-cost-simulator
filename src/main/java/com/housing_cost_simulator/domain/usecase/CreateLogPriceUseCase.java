package com.housing_cost_simulator.domain.usecase;

import com.housing_cost_simulator.application.mapper.PriceMapper;
import com.housing_cost_simulator.application.mapper.UserMapper;
import com.housing_cost_simulator.domain.model.entities.LogPrice;
import com.housing_cost_simulator.domain.model.entities.Price;
import com.housing_cost_simulator.domain.model.entities.User;
import com.housing_cost_simulator.infrastructure.persistence.LogPricePersistence;
import com.housing_cost_simulator.infrastructure.persistence.UserPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateLogPriceUseCase {

    private final LogPricePersistence logPricePersistence;
    private final RecoverLoggedUserUseCase recoverLoggedUserUseCase;
    private final UserPersistence userPersistence;
    private final PriceMapper priceMapper;
    private final UserMapper userMapper;


    public void execute(Price price) {
        LogPrice logPrice = priceMapper.priceToLogPrice(price);
        User userRecovered = userPersistence.findUserByEmail(
              recoverLoggedUserUseCase.getCurrentUser()
        );
        userRecovered.setPassword(null);
        logPrice.setUser(
              userRecovered
        );

        logPricePersistence.persist(logPrice);
    }

}
