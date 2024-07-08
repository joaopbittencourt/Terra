package com.house58.terra.schedule.service;

import com.house58.terra.schedule.dao.PatientRecordRepository;
import com.house58.terra.schedule.entity.PatientRecord;
import com.house58.terra.schedule.entity.Shedule;
import org.springframework.security.core.parameters.P;

import java.util.Date;

public class RegisterPatientRecord {
    private final PatientRecordRepository patientRecordRepository;

    public RegisterPatientRecord(PatientRecordRepository patientRecordRepository) {
        this.patientRecordRepository = patientRecordRepository;
    }

    public PatientRecord register(Shedule shedule, String description){

        PatientRecord patientRecord = new PatientRecord();
        patientRecord.setShedule(shedule);
        patientRecord.setData(new Date(System.currentTimeMillis()));
        patientRecord.setDescription(description);
        return this.patientRecordRepository.save(patientRecord);
    }
}
