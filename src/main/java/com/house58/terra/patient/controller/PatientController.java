package com.house58.terra.patient.controller;

import com.house58.terra.patient.dao.PatientRepository;
import com.house58.terra.patient.entity.Patient;
import com.house58.terra.patient.service.RegisterPatient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/patient")
public class PatientController {
    private RegisterPatient registerPatient;
    private final PatientRepository patientRepository;
    PatientController(RegisterPatient registerPatient, PatientRepository patientRepository){
        this.registerPatient = registerPatient;
        this.patientRepository = patientRepository;
    }

    @PostMapping("/save-patient")
    private Patient save(@RequestBody Patient patient){
        return this.registerPatient.register(patient);
    }

    @GetMapping
    private List<Patient> findAll(){
        return this.patientRepository.findAll();
    }
    @DeleteMapping("/delete-patient")
    private Patient remove(@RequestBody Patient patient){
        patient.setStatus(false);
        return this.patientRepository.save(patient);
    }




}
