package com.house58.terra.patient.controller;

import com.house58.terra.patient.dao.GuardianRepository;
import com.house58.terra.patient.entity.Guardians;
import com.house58.terra.patient.service.RegisterGuardian;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guardian")
public class GuardianController {

    private final RegisterGuardian registerGuardian;

    public GuardianController(RegisterGuardian registerGuardian) {
        this.registerGuardian = registerGuardian;
    }

    @PostMapping("save-guardian")
    public Guardians register(@RequestBody Guardians guardian){
        return this.registerGuardian.register(guardian);
    }

    @GetMapping("/cpf/{cpf}")
    private Guardians findByCpf(@PathVariable Long cpf){
        return this.registerGuardian.getGuardianRepository(cpf);
    }
}
