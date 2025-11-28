package com.house58.terra.contract.entity;

import com.house58.terra.therapy.entity.Therapy;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class TherapyList {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;
    private Therapy therapy;
    private Integer count;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
