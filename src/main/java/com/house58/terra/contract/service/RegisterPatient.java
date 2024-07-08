package com.house58.terra.contract.service;

import com.house58.terra.contract.dto.PatientDTO;
import com.house58.terra.patient.dao.ResponsibleRepository;
import com.house58.terra.patient.entity.Patient;
import com.house58.terra.patient.entity.Responsible;

public class RegisterPatient {
    private final ResponsibleRepository responsibleRepository;

    public RegisterPatient(ResponsibleRepository responsibleRepository) {
        this.responsibleRepository = responsibleRepository;
    }


    public void register(PatientDTO patientDTO){
        Patient patient = new Patient();

        patient.setName(patientDTO.getName());
        patient.setBirthDay(patientDTO.getDateOfBird());
        patient.setDocument(patientDTO.getCpf());

        Responsible responsible = new Responsible();
        responsible.setName(patientDTO.getNameOfPersonResponsible());
        responsible.setDocument(patientDTO.getCpfOfPersibResponsible());
        responsible.setPatient(patient);

        this.responsibleRepository.save(responsible);

    }
}
