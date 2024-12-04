package com.housing_cost_simulator.domain.usecase;

import static java.util.Objects.nonNull;

import com.housing_cost_simulator.application.mapper.AddressMapper;
import com.housing_cost_simulator.application.service.AddressService;
import com.housing_cost_simulator.domain.exception.UnprocessableEntityException;
import com.housing_cost_simulator.domain.model.entities.Address;
import com.housing_cost_simulator.domain.model.entities.User;
import com.housing_cost_simulator.infrastructure.persistence.UserPersistence;
import com.housing_cost_simulator.entrypoint.dto.RegisterUserRequest;
import com.housing_cost_simulator.shared.util.PasswordEncoderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterUserUsecase {

    private final UserPersistence userPersistence;
    private final FindUserUseCase findUserUseCase;
    private final AddressService addressService;
    private final AddressMapper addressMapper;
    private final PasswordEncoderUtil passwordEncoderUtil;


    public void execute(RegisterUserRequest userRequest) {

        if (nonNull(findUserUseCase.execute(userRequest.getEmail()))) {
            throw new UnprocessableEntityException("Email already registered");
        }

        String cep = userRequest.getCep();

        Address address = addressMapper.addressDtoToAddress(
              addressService.findAddressByCEP(cep)
        );

        addressService.saveAddress(address);

        User userToBeSaved = this.buildUser(
              address,
              userRequest
        );

        userPersistence.saveUser(userToBeSaved);
    }

    private User buildUser(Address address, RegisterUserRequest userRequest) {
        String encryptedPassword = passwordEncoderUtil.encode(userRequest.getPassword());
        return User.builder()
              .address(address)
              .email(userRequest.getEmail())
              .password(encryptedPassword)
              .role("USER").build();
    }

}
