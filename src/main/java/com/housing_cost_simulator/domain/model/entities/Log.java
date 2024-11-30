package com.housing_cost_simulator.domain.model.entities;

import java.time.LocalDateTime;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "log")
public class Log {
    @Id
    private String id;
    private Address address;
    private User user;
    private LocalDateTime created = LocalDateTime.now();
}
