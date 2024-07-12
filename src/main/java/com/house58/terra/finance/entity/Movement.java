package com.house58.terra.finance.entity;

import com.house58.terra.contract.entity.Contract;
import com.house58.terra.user.entity.User;
import jakarta.persistence.*;

import java.util.UUID;


@Entity(name = "movement")
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Double value;
    @ManyToOne
    private Contract contract;
    @ManyToOne
    private User user;

    public Movement() {

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
