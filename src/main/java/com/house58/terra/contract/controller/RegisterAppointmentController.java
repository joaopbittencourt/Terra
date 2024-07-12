package com.house58.terra.contract.controller;

import com.house58.terra.contract.service.RegisterAppointment;
import com.house58.terra.patient.entity.Patient;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/register-appointment")
public class RegisterAppointmentController {
    public RegisterAppointment registerAppointment;

    public RegisterAppointmentController(RegisterAppointment registerAppointment){
        this.registerAppointment =  registerAppointment;
    }

    @PostMapping("/register-register-appointment")
    public void register(@RequestBody Patient patient, @RequestBody Set<SessionIdEnum> sessionsId){
        this.registerAppointment.register(patient, sessionsId);
    }

    @GetMapping("/")
    public String getHellow(){
        return "Relou mundo";
    }

}
