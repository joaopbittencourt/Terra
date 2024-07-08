package com.house58.terra.contract.dto;

import com.house58.terra.user.entity.Discipline;

import java.util.Date;
import java.util.List;

public class PatientDTO {
    private String name;
    private String nameOfPersonResponsible;
    private String cpf;
    private String cpfOfPersibResponsible;
    private Date dateOfBird;
    private List<Discipline> discipline;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Discipline> getDiscipline() {
        return discipline;
    }

    public void setDiscipline(List<Discipline> discipline) {
        this.discipline = discipline;
    }
}
