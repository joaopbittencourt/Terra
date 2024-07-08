package com.house58.terra.contract.service;

import com.house58.terra.patient.entity.Anamnesis;
import com.house58.terra.contract.dao.AnamnesisRepository;
import com.house58.terra.contract.dto.AnamnesisDTO;
import com.house58.terra.patient.dao.PatientRepository;
import com.house58.terra.patient.dao.ResponsibleRepository;
import com.house58.terra.patient.entity.Responsible;

public class RegisterAnamnesis {
    private final AnamnesisRepository anamnesisRepository;
    private final PatientRepository patientRepository;
    private final ResponsibleRepository responsibleRepository;

    public RegisterAnamnesis(AnamnesisRepository anamnesisRepository, PatientRepository patientRepository, ResponsibleRepository responsibleRepository){
        this.anamnesisRepository= anamnesisRepository;
        this.patientRepository = patientRepository;
        this.responsibleRepository = responsibleRepository;
    }

    public void register (AnamnesisDTO anamnesisDTO){
        Responsible responsible = anamnesisDTO.getResponsible();
        responsible.setPatient(anamnesisDTO.getPatient());
        Responsible responsible1 = responsibleRepository.save(responsible);
        anamnesisDTO.getDisciplineAnamneseDTO().forEach(disciplineAnamneseDTO -> {
            Anamnesis anamnesis = new Anamnesis();
            anamnesis.setDate(disciplineAnamneseDTO.getData());
            anamnesis.setDiscipline(disciplineAnamneseDTO.getDiscipline());
            anamnesis.setPatient(responsible1.getPatient());
            this.anamnesisRepository.save(anamnesis);
        });

    }
}
