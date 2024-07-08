package com.house58.terra.finance.entity;

import com.house58.terra.contract.entity.Contract;
import com.house58.terra.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity(name = "movimentacao")
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;
    private Double value;

    private Contract contract;
    private User user;
}
