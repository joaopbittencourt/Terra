package com.house58.terra.finance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "saldo")
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;
    private Double value;
}
