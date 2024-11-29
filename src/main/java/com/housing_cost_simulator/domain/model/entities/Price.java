package com.housing_cost_simulator.domain.model.entities;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.PERSIST)
    private Address address;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Product product;

    private LocalDateTime created = LocalDateTime.now();

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Store store;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User creator;
}
