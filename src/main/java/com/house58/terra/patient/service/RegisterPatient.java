package com.house58.terra.patient.service;

import com.house58.terra.contract.dao.ContractRepository;
import com.house58.terra.contract.entity.Contract;
import com.house58.terra.healthinsurance.dao.HealthInsuranceRepository;
import com.house58.terra.healthinsurance.entity.HealthInsurance;
import com.house58.terra.patient.dao.PatientRepository;
import com.house58.terra.patient.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegisterPatient {

    private PatientRepository patientRepository;
    private HealthInsuranceRepository healthInsuranceRepository;
    private ContractRepository contractRepository;
    public RegisterPatient(PatientRepository patientRepository, HealthInsuranceRepository healthInsuranceRepository, ContractRepository contractRepository) {
        this.patientRepository = patientRepository;
        this.healthInsuranceRepository = healthInsuranceRepository;
        this.contractRepository = contractRepository;
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
