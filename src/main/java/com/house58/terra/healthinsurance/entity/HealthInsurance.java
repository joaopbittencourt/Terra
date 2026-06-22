package com.house58.terra.healthinsurance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.house58.terra.contract.entity.Contract;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name= "health_insurance")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HealthInsurance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String operatorCod;
    @Column(nullable = false)
    private String productCod;

    private String name;

    private Date effetiveDate;

    private Date dateOfValidity;

    private Boolean status;

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

    public String getOperatorCod() {
        return operatorCod;
    }

    public void setOperatorCod(String operatorCod) {
        this.operatorCod = operatorCod;
    }

    public String getProductCod() {
        return productCod;
    }

    public void setProductCod(String productCod) {
        this.productCod = productCod;
    }

}
