package com.house58.terra.contract.entity;

import com.house58.terra.schedule.entity.Shedule;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "CarePlan")
public class CarePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;

    private String plan;

    private Integer countSession;
    @OneToMany
    private List<Shedule> shedule;

    private Modalito modalito;

    private BigDecimal value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Integer getCountSession() {
        return countSession;
    }

    public void setCountSession(Integer countSession) {
        this.countSession = countSession;
    }

    public Modalito getModality() {
        return modalito;
    }

    public void setModality(Modalito modalito) {
        this.modalito = modalito;
   }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public List<Shedule> getShedule() {
        return shedule;
    }

    public void setShedule(List<Shedule> shedule) {
        this.shedule = shedule;
    }
}
