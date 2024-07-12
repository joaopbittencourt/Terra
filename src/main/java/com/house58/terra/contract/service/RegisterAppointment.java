package com.house58.terra.contract.service;

import com.house58.terra.patient.dao.PatientRepository;
import com.house58.terra.patient.entity.Patient;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RegisterAppointment {
    private final PatientRepository patientRepository;

    public RegisterAppointment(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public Patient register(Patient patient, Set<SessionIdEnum> sessionsIdEnum){
        patient.setSessionsId(sessionsIdEnum);
        return patientRepository.save(patient);
    }

}
