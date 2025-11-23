package com.house58.terra.finance.entity;

import com.house58.terra.contract.entity.Contract;
import com.house58.terra.healthinsurance.entity.HealthInsurance;
import com.house58.terra.user.entity.Discipline;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name = "cost")
public class Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Nullable
    private HealthInsurance healthInsurance;
    @Nullable
    private Contract contract;
    private Discipline discipline;
    private Double value;
    private Boolean status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Nullable
    public HealthInsurance getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(@Nullable HealthInsurance healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    @Nullable
    public Contract getContract() {
        return contract;
    }

    public void setContract(@Nullable Contract contract) {
        this.contract = contract;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
