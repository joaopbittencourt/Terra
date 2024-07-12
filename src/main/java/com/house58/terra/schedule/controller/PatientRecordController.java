package com.house58.terra.schedule.controller;

import com.house58.terra.schedule.dao.PatientRecordRepository;
import com.house58.terra.schedule.entity.PatientRecord;
import com.house58.terra.schedule.entity.Shedule;
import com.house58.terra.schedule.service.RegisterPatientRecord;
import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping("/prontuario")
public class PatientRecordController {
    private final PatientRecordRepository patientRecordRepository;
    private final RegisterPatientRecord registerPatientRecord;

    public PatientRecordController(PatientRecordRepository patientRecordRepository, RegisterPatientRecord registerPatientRecord) {
        this.patientRecordRepository = patientRecordRepository;
        this.registerPatientRecord = registerPatientRecord;
    }

    @DeleteMapping("/delete-patient-record")
    private PatientRecord delete(@RequestBody PatientRecord patientRecord){
        return this.patientRecordRepository.save(patientRecord);
    }

    @PostMapping("/register-patient-record")
    public PatientRecord register(@RequestBody Shedule shedule, @RequestBody String description){
        return this.registerPatientRecord.register(shedule, description);
    }
}
