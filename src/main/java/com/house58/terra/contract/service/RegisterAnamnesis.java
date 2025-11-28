package com.house58.terra.contract.service;

import com.house58.terra.contract.dao.AnamnesisRepository;
import com.house58.terra.contract.dto.AnamnesisDTO;
import com.house58.terra.patient.dao.PatientRepository;
import com.house58.terra.patient.dao.ResponsibleRepository;
import com.house58.terra.patient.entity.Anamnesis;
import com.house58.terra.patient.entity.Patient;
import com.house58.terra.patient.entity.Responsible;
import org.springframework.stereotype.Service;

@Service
public class RegisterAnamnesis {
    private final AnamnesisRepository anamnesisRepository;
    private final PatientRepository patientRepository;
    private final ResponsibleRepository responsibleRepository;

    public RegisterAnamnesis(AnamnesisRepository anamnesisRepository, PatientRepository patientRepository, ResponsibleRepository responsibleRepository){
        this.anamnesisRepository= anamnesisRepository;
        this.patientRepository = patientRepository;
        this.responsibleRepository = responsibleRepository;
    }

    public Patient registerPatient(Patient patient){
        return this.patientRepository.save(patient);
    }
    public Responsible registerReponsiblw(Responsible responsible){
        return this.responsibleRepository.save(responsible);
    }
    public void register (AnamnesisDTO anamnesisDTO){
        Responsible responsible = anamnesisDTO.getResponsible();
        Patient patient = this.registerPatient(anamnesisDTO.getResponsible().getPatient());
        responsible.setPatient(this.registerPatient(patient));

        anamnesisDTO.getTherapyAnamneseDTO().forEach(therapyAnamneseDTO -> {
            Anamnesis anamnesis = new Anamnesis();
            anamnesis.setDate(therapyAnamneseDTO.getData());
           // anamnesis.setTherapy(therapyAnamneseDTO.getTherapy());
            anamnesis.setPatient(patient);
            this.anamnesisRepository.save(anamnesis);
        });

    }
}
