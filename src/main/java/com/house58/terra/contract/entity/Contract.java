package com.house58.terra.contract.entity;

import com.house58.terra.contract.dto.DisciplineAnamneseDTO;
import com.house58.terra.patient.entity.Patient;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import com.house58.terra.user.entity.Discipline;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name= "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;

    private Date effetiveDate;

    private Date dateOfValidity;

    private List<CarePlan> carePlan;

    private HealthInsurance healthInsurance;

    private Patient patient;

    private Set<DisciplineAnamneseDTO> disciplineAnamneseDTO;

    private Set<SessionIdEnum> sessionsId;

    private String observation;

    private Boolean status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<CarePlan> getCarePlan() {
        return carePlan;
    }

    public void setCarePlan(List<CarePlan> carePlan) {
        this.carePlan = carePlan;
    }

    public String getObservation() {
        return observation;
    }

    public HealthInsurance getHealthInsurance() {
        return healthInsurance;
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

    public Set<DisciplineAnamneseDTO> getDisciplineAnamneseDTO() {
        return disciplineAnamneseDTO;
    }

    public void setDisciplineAnamneseDTO(Set<DisciplineAnamneseDTO> disciplineAnamneseDTO) {
        this.disciplineAnamneseDTO = disciplineAnamneseDTO;
    }

    public Set<SessionIdEnum> getSessionsId() {
        return sessionsId;
    }

    public void setSessionsId(Set<SessionIdEnum> sessionsId) {
        this.sessionsId = sessionsId;
    }
}
