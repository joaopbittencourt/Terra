package com.house58.terra.healthinsurance.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name= "health-insurance")
public class HealthInsurance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private Date effetiveDate;

    private Date dateOfValidity;

    private Boolean status;

    private String number;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEffetiveDate() {
        return effetiveDate;
    }

    public void setEffetiveDate(Date effetiveDate) {
        this.effetiveDate = effetiveDate;
    }

    public Date getDateOfValidity() {
        return dateOfValidity;
    }

    public void setDateOfValidity(Date dateOfValidity) {
        this.dateOfValidity = dateOfValidity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
