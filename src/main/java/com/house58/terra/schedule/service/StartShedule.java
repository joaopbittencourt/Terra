package com.house58.terra.schedule.service;

import com.house58.terra.contract.entity.Contract;
import com.house58.terra.patient.entity.Patient;
import com.house58.terra.schedule.dao.PatientRecordRepository;
import com.house58.terra.schedule.dao.SessionRepository;
import com.house58.terra.schedule.dao.SheduleRepository;
import com.house58.terra.schedule.entity.SShedule;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

@Service
public class StartShedule {

    private final PatientRecordRepository patientRecordRepository;
    private final SessionRepository sessionRepository;
    private final SheduleRepository sheduleRepository;

    public StartShedule(PatientRecordRepository patientRecordRepository, SessionRepository sessionRepository, SheduleRepository sheduleRepository) {
        this.patientRecordRepository = patientRecordRepository;
        this.sessionRepository = sessionRepository;
        this.sheduleRepository = sheduleRepository;
    }

    public SShedule initSession(Patient patient, SessionIdEnum sessionIdEnum, Contract contract){
        SShedule shedule = new SShedule();
        shedule.setContract(contract);
        shedule.setSessionIdEnum(sessionIdEnum);
        shedule.setCreatedAt(Timestamp.from(Instant.now()));
        return this.sheduleRepository.save(shedule);
    }

}
