package com.house58.terra.schedule.controller;

import com.house58.terra.contract.entity.Contract;
import com.house58.terra.schedule.dao.SessionRepository;
import com.house58.terra.schedule.dto.ClinicalEncounterDTO;
import com.house58.terra.schedule.dto.SessionDTO;
import com.house58.terra.schedule.entity.SShedule;
import com.house58.terra.schedule.entity.Session;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import com.house58.terra.schedule.service.RegisterSession;
import com.house58.terra.therapy.entity.Therapy;
import com.house58.terra.user.entity.Team;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/session")
public class SessionController  {
    private final SessionRepository sessionRepository;
    private final RegisterSession registerSession;
    public SessionController(SessionRepository sessionRepository, RegisterSession registerSession ) {
        this.sessionRepository = sessionRepository;
        this.registerSession = registerSession;
    }
    /*
    @PostMapping
    private Session save(@RequestBody Session session){
        return this.sessionRepository.save(session);
    }
    */
    @PostMapping("/registerSession")
    private Session registerSession(
            @RequestBody ClinicalEncounterDTO clinicalEncounterDTO,
            @AuthenticationPrincipal Jwt jwt){
        return this.registerSession.registerSession(clinicalEncounterDTO, jwt);
    }
    @DeleteMapping("/delete-session")
    private Session delete(@RequestBody Session session){
        session.setStatus(false);
        return this.sessionRepository.save(session);
    }


    @GetMapping("/contract/{contractId}")
    private List<SessionDTO> getSScheduleAll(@PathVariable String contractId){
        return this.registerSession.getByContract(contractId);
    }
}
