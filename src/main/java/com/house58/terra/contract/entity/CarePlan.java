package com.house58.terra.contract.entity;

import com.house58.terra.modality.entity.Modality;
import com.house58.terra.schedule.entity.Shedule;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "care-plan")
public class CarePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String plan;

    private Integer countSession;
    @OneToMany
    private List<Shedule> shedule;

    @ManyToOne
    private Modality modality;

    private BigDecimal value;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public Modality getModality() {
        return modality;
    }

    public void setModality(Modality modality) {
        this.modality = modality;
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
