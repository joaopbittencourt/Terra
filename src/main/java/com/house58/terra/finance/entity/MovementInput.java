package com.house58.terra.finance.entity;

import com.house58.terra.contract.entity.Contract;
import com.house58.terra.user.entity.User;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;


@Entity(name = "movement-input")
public class MovementInput {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Double value;
    private String description;
    @ManyToOne
    private Contract contract;
    private String user;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    public MovementInput() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
