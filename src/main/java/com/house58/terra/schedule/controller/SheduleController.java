package com.house58.terra.schedule.controller;

import com.house58.terra.contract.dto.MonthlyContractDTO;
import com.house58.terra.contract.entity.Contract;
import com.house58.terra.contract.entity.MonthlyContract;
import com.house58.terra.schedule.dao.SheduleRepository;
import com.house58.terra.schedule.dto.DataTherapyPatienteDTO;
import com.house58.terra.schedule.dto.ScheduleDTO;
import com.house58.terra.schedule.entity.SShedule;
import com.house58.terra.schedule.service.RegisterShedule;
import com.house58.terra.schedule.service.StartShedule;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController 
@RequestMapping("/schedule")
public class SheduleController {
    private final SheduleRepository sheduleRepository;
    private final StartShedule startShedule;
    private final RegisterShedule registerShedule;
    public SheduleController(
            SheduleRepository sheduleRepository,
            StartShedule startShedule,
            RegisterShedule registerShedule) {
        this.sheduleRepository = sheduleRepository;
        this.startShedule =  startShedule;
        this.registerShedule = registerShedule;
    }

    @PostMapping("register-schedule/{contractId}")
    @Consumes(MediaType.APPLICATION_JSON)
    private List<SShedule> registerShedule(
            @PathVariable String contractId,
            @RequestBody List<DataTherapyPatienteDTO> dataTherapyPatienteDTOList){
        return this.registerShedule.register(contractId, dataTherapyPatienteDTOList);
    }

    @GetMapping("/active")
    private List<SShedule> getSSchedule(){
        return this.registerShedule.getActiveSchedule();
    }

    @GetMapping("/contract/{contractId}/peer-therapist")
    private List<ScheduleDTO> getSSchedulePeerThearapist(@PathVariable String contractId){
        return this.registerShedule.getScheduleOrientedPeerTherapist(contractId);
    }



    @GetMapping("/contract/{contractId}")
    private List<SShedule> getSScheduleAll(@PathVariable String contractId){
        return this.registerShedule.getByContract(contractId);
    }

    @DeleteMapping("/delete-schedule")
    private SShedule delete(@RequestBody SShedule shedule){
       // shedule.setStatus(false);
        return this.sheduleRepository.save(shedule);
    }
/*
    @PostMapping("/init-shedule")
    private SShedule initShedule(@RequestBody SShedule shedule){
        return this.startShedule.initSession(shedule.getContract().getPatient(), shedule.getSessionIdEnum(), shedule.getContract());
    }
*/
}
