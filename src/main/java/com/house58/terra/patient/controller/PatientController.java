package com.house58.terra.patient.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.house58.terra.patient.dao.PatientRepository;
import com.house58.terra.patient.entity.Patient;
import com.house58.terra.patient.service.RegisterPatient;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Parameter;
import java.util.List;
import java.util.UUID;

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
    private Patient register(@RequestBody Patient patient){
        return patientRepository.save(patient);
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

    @GetMapping("/{patientId}")
    private Patient findById(@PathVariable UUID patientId){
        System.out.println(patientId);
        return this.patientRepository.getById(patientId);
    }



}
