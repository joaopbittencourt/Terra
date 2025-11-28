package com.house58.terra.patient.service;

import com.house58.terra.contract.dao.AnamnesisRepository;
import com.house58.terra.contract.dao.ContractRepository;
import com.house58.terra.contract.entity.Contract;
import com.house58.terra.patient.dao.PatientRepository;
import com.house58.terra.patient.dto.PatientDTO;
import com.house58.terra.patient.entity.Anamnesis;
import com.house58.terra.patient.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegisterPatient {

    private PatientRepository patientRepository;
    private ContractRepository contractRepository;
    private AnamnesisRepository anamnesisRepository;
    public RegisterPatient(PatientRepository patientRepository, ContractRepository contractRepository, AnamnesisRepository anamnesisRepository) {
        this.patientRepository = patientRepository;
        this.contractRepository = contractRepository;
        this.anamnesisRepository = anamnesisRepository;
    }

    public Patient register(Patient patient) {
        try {
            patient =  patient.getId() !=  null ? this.patientRepository.getById(patient.getId()) : patient;
            return this.patientRepository.save(patient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
