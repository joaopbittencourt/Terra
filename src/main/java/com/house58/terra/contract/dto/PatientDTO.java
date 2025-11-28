package com.house58.terra.contract.dto;

import com.house58.terra.therapy.entity.Therapy;

import java.util.Date;
import java.util.List;

public class PatientDTO {
    private String firstName;
    private String lastName;
    private String nameOfPersonResponsible;
    private String cpf;
    private String cpfOfPersibResponsible;
    private Date dateOfBird;
    private List<Therapy> therapyList;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNameOfPersonResponsible() {
        return nameOfPersonResponsible;
    }

    public void setNameOfPersonResponsible(String nameOfPersonResponsible) {
        this.nameOfPersonResponsible = nameOfPersonResponsible;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpfOfPersibResponsible() {
        return cpfOfPersibResponsible;
    }

    public void setCpfOfPersibResponsible(String cpfOfPersibResponsible) {
        this.cpfOfPersibResponsible = cpfOfPersibResponsible;
    }

    public Date getDateOfBird() {
        return dateOfBird;
    }

    public void setDateOfBird(Date dateOfBird) {
        this.dateOfBird = dateOfBird;
    }

    public List<Therapy> getTherapyList() {return therapyList;}

    public void setTherapyList(List<Therapy> therapyList) {this.therapyList = therapyList;}
}
