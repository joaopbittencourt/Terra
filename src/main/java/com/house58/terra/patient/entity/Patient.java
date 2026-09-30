package com.house58.terra.patient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.house58.terra.contract.entity.Contract;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "patient")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    @ManyToMany
    private List<Guardians> guardians;
    @OneToMany(mappedBy= "patient", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Contract> contracts;
    private Date birthDay;
    private String phoneNumber;
    private String gender;
    @Column(name = "document", unique = true, nullable = true)
    private String document;
    @Column(name = "register-plan", unique = true, nullable = true)
    private String registerPlan;
    private Boolean status;
    private String agreement;
    private String allergy;
    private Date creaded;
    private Date updated;
    private String observations;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Guardians> getGuardians() {
        return guardians;
    }

    public void setGuardians(List<Guardians> guardians) {
        this.guardians = guardians;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public Date getCreaded() {
        return creaded;
    }

    public void setCreaded(Date creaded) {
        this.creaded = creaded;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getRegisterPlan() { return registerPlan; }

    public void setRegisterPlan(String registerPlan) {this.registerPlan = registerPlan; }
}
