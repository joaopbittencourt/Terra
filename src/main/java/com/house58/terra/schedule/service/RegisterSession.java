package com.house58.terra.schedule.service;

import com.house58.terra.contract.dao.ContractRepository;
import com.house58.terra.contract.dao.TherapyListRepository;
import com.house58.terra.contract.entity.Contract;
import com.house58.terra.patient.dao.PatientRepository;
import com.house58.terra.schedule.dao.SessionRepository;
import com.house58.terra.schedule.dao.SheduleRepository;
import com.house58.terra.schedule.entity.Session;
import com.house58.terra.schedule.entity.Shedule;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import com.house58.terra.therapy.dao.TherapyRepository;
import com.house58.terra.therapy.entity.Therapy;
import com.house58.terra.user.dao.TeamRepository;
import com.house58.terra.user.entity.Team;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegisterSession {

    private final PatientRepository patientRepository;
    private final SessionRepository sessionRepository;
    private final SheduleRepository sheduleRepository;
    private final TherapyListRepository therapyListRepository;
    private final TherapyRepository therapyRepository;
    private final TeamRepository teamRepository;
    private final ContractRepository contractRepository;

    public RegisterSession(PatientRepository patientRepository,
                           SessionRepository sessionRepository,
                           SheduleRepository sheduleRepository,
                           TherapyListRepository therapyListRepository,
                           TherapyRepository therapyRepository,
                           TeamRepository teamRepository,
                           ContractRepository contractRepository) {
        this.patientRepository = patientRepository;
        this.sessionRepository = sessionRepository;
        this.sheduleRepository = sheduleRepository;
        this.therapyListRepository = therapyListRepository;
        this.therapyRepository = therapyRepository;
        this.teamRepository = teamRepository;
        this.contractRepository = contractRepository;

    }

    public Session registerSession(Contract contract, Team team, Therapy therapy, SessionIdEnum sessionIdEnum){
        Shedule shedule = this.sheduleRepository.findSheduleBySessionIdEnum(contract.getId(), team.getId(), sessionIdEnum.name());

        if(shedule == null){
            throw new RuntimeException("Sessao não registrada");
        }

        Session session = new Session();
        session.setSessionId(sessionIdEnum);
        session.setContract(contract);
        session.setTherapy(therapy);
        session.setDate(new Date(System.currentTimeMillis()));

        return this.sessionRepository.save(session);

    }

}
