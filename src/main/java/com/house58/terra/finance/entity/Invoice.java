package com.house58.terra.finance.entity;

import com.house58.terra.contract.entity.CarePlan;
import com.house58.terra.contract.entity.Contract;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "nota")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;

    private Contract contract;

    private CarePlan carePlan;

    private String description;

    private String status;
}
