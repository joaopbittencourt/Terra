package com.house58.terra.patient.service;

import com.house58.terra.contract.dao.ContractRepository;
import com.house58.terra.patient.dao.PatientRepository;
import com.house58.terra.patient.entity.Patient;
import com.house58.terra.servicePackage.dao.ServicePackageRepository;
import org.springframework.stereotype.Service;

@Service
public class AppointmentRegistration {

    private PatientRepository patientRepository;
    private ContractRepository contractRepository;
    private ServicePackageRepository servicePackageRepository;

    public AppointmentRegistration(PatientRepository patientRepository,
                                   ContractRepository contractRepository,
                                   ServicePackageRepository servicePackageRepository){
        this.patientRepository = patientRepository;
        this.contractRepository = contractRepository;
        this.servicePackageRepository = servicePackageRepository;
    }

    public Patient register(){
        return new Patient();
    }
}
