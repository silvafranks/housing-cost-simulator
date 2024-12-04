package com.housing_cost_simulator.domain.usecase;

import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.application.dto.UserDto;
import com.housing_cost_simulator.application.mapper.PriceMapper;
import com.housing_cost_simulator.application.mapper.UserMapper;
import com.housing_cost_simulator.domain.model.entities.LogPrice;
import com.housing_cost_simulator.infrastructure.persistence.LogPricePersistence;
import com.housing_cost_simulator.infrastructure.persistence.UserPersistence;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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


    public void execute(PriceDto priceDto) {
        LogPrice logPrice = priceMapper.priceDtoToLogPrice(priceDto);


        UserDto loggedUser = userMapper.userToUserDto(
              userPersistence.findUserByEmail(
                    recoverLoggedUserUseCase.getCurrentUser()
              )
        );
        logPrice.setUser(loggedUser);
        logPricePersistence.persist(logPrice);
    }

}
