package com.housing_cost_simulator.domain.model.entities;

import com.housing_cost_simulator.application.dto.UserDto;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "log_price")
public class LogPrice {

    @Id
    private String id;
    private Address address;
    private UserDto user;
    private Product product;
    private LocalDateTime created = LocalDateTime.now().minusHours(3);

}
