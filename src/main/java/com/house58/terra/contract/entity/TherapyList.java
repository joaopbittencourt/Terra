package com.house58.terra.contract.entity;

import com.house58.terra.therapy.entity.Therapy;
import jakarta.persistence.*;

import java.util.UUID;

public class TherapyList {


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
