package com.house58.terra.finance.entity;

import com.house58.terra.contract.entity.CarePlan;
import com.house58.terra.contract.entity.Contract;
import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Contract contract;

    @ManyToOne
    private CarePlan carePlan;

    private String description;

    private String status;
}
