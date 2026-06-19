package com.house58.terra.contract.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.house58.terra.contract.dto.TherapyAnamneseDTO;
import com.house58.terra.healthinsurance.entity.HealthInsurance;
import com.house58.terra.modality.entity.Modality;
import com.house58.terra.patient.entity.Patient;
import com.house58.terra.schedule.entity.SShedule;
import com.house58.terra.schedule.entity.Session;
import com.house58.terra.therapy.entity.Therapy;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name= "contract")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Contract implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Date effetiveDate;

    private Date dateOfValidity;
    @Transient
    private List<Therapy> therapyLists;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "health_insurance_id")
    private HealthInsurance healthInsurance;

    private Modality modality;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany(mappedBy="contract", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SShedule> shedules;

    @Transient
    private Set<TherapyAnamneseDTO> therapyAnamneseDTO;

    private String observation;

    private Boolean status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public List<Therapy> getTherapyLists() {return therapyLists;}

    public void setTherapyLists(List<Therapy> therapyLists) {this.therapyLists = therapyLists;}

    public String getObservation() {
        return observation;
    }

    public HealthInsurance getHealthInsurance() {
        return this.healthInsurance;
    }

    public void setHealthInsurance(HealthInsurance healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Set<TherapyAnamneseDTO> getTherapyAnamneseDTO() {
        return therapyAnamneseDTO;
    }

    public void setTherapyAnamneseDTO(Set<TherapyAnamneseDTO> therapyAnamneseDTO) {
        this.therapyAnamneseDTO = therapyAnamneseDTO;
    }

    public List<SShedule> getShedules() {
        return shedules;
    }

    public void setShedules(List<SShedule> shedules) {
        this.shedules = shedules;
    }

    public Modality getModality() {
        return modality;
    }

    public void setModality(Modality modality) {
        this.modality = modality;
    }
}
