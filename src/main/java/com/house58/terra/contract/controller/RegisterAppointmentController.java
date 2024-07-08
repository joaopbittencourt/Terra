package com.house58.terra.contract.controller;

import com.house58.terra.contract.service.RegisterAppointment;
import com.house58.terra.patient.entity.Patient;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController("registerAppointment")
public class RegisterAppointmentController {
    public RegisterAppointment registerAppointment;

    public RegisterAppointmentController(RegisterAppointment registerAppointment){
        this.registerAppointment =  registerAppointment;
    }

    @PostMapping
    public void register(@RequestBody Patient patient, @RequestBody Set<SessionIdEnum> sessionsId){
        this.registerAppointment.register(patient, sessionsId);
    }

}
