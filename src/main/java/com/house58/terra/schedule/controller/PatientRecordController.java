package com.house58.terra.schedule.controller;

import com.house58.terra.schedule.dao.PatientRecordRepository;
import com.house58.terra.schedule.entity.PatientRecord;
import com.house58.terra.schedule.entity.Shedule;
import com.house58.terra.schedule.service.RegisterPatientRecord;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController("prontuario")
public class PatientRecordController {
    private final PatientRecordRepository patientRecordRepository;
    private final RegisterPatientRecord registerPatientRecord;

    public PatientRecordController(PatientRecordRepository patientRecordRepository, RegisterPatientRecord registerPatientRecord) {
        this.patientRecordRepository = patientRecordRepository;
        this.registerPatientRecord = registerPatientRecord;
    }
    @PostMapping
    private PatientRecord save(@RequestBody PatientRecord patientRecord){
        return this.patientRecordRepository.save(patientRecord);
    }

    @PutMapping
    private PatientRecord update(@RequestBody PatientRecord patientRecord){
        return this.patientRecordRepository.save(patientRecord);
    }

    @DeleteMapping
    private PatientRecord delete(@RequestBody PatientRecord patientRecord){
        return this.patientRecordRepository.save(patientRecord);
    }

    @PostMapping("register")
    public PatientRecord register(@RequestBody Shedule shedule, @RequestBody String description){
        return this.registerPatientRecord.register(shedule, description);
    }
}
