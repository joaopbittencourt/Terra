package com.house58.terra.schedule.controller;

import com.house58.terra.schedule.dao.SheduleRepository;
import com.house58.terra.schedule.entity.Shedule;
import com.house58.terra.schedule.service.StartShedule;
import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping("/shedule")
public class SheduleController {
    private final SheduleRepository sheduleRepository;
    private final StartShedule startShedule;
    public SheduleController(SheduleRepository sheduleRepository, StartShedule startShedule) {
        this.sheduleRepository = sheduleRepository;
        this.startShedule =  startShedule;
    }
    @PostMapping("/save-shedule")
    private Shedule save(@RequestBody Shedule shedule){
        return this.sheduleRepository.save(shedule);
    }


    @DeleteMapping("/delete-schedule")
    private Shedule delete(@RequestBody Shedule shedule){
       // shedule.setStatus(false);
        return this.sheduleRepository.save(shedule);
    }

    @PostMapping("/init-shedule")
    private Shedule initShedule(@RequestBody Shedule shedule){
        return this.startShedule.initSession(shedule.getContract().getPatient(), shedule.getSessionIdEnum(), shedule.getContract());
    }

}
