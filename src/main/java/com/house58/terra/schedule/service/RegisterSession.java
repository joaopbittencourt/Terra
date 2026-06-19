package com.house58.terra.schedule.service;

import com.house58.terra.contract.dao.ContractRepository;
import com.house58.terra.contract.entity.Contract;
import com.house58.terra.patient.dao.PatientRepository;
import com.house58.terra.schedule.dao.SessionRepository;
import com.house58.terra.schedule.dao.SheduleRepository;
import com.house58.terra.schedule.dto.ClinicalEncounterDTO;
import com.house58.terra.schedule.dto.SessionDTO;
import com.house58.terra.schedule.entity.Session;
import com.house58.terra.schedule.entity.SShedule;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import com.house58.terra.therapy.dao.TherapyRepository;
import com.house58.terra.user.dao.TeamRepository;
import com.house58.terra.user.entity.Team;
import com.house58.terra.user.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import com.house58.terra.config.JwtConverter;

import java.sql.Timestamp;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class RegisterSession {

    private final PatientRepository patientRepository;
    private final SessionRepository sessionRepository;
    private final SheduleRepository sheduleRepository;
    private final TherapyRepository therapyRepository;
    private final TeamRepository teamRepository;
    private final ContractRepository contractRepository;

    public RegisterSession(PatientRepository patientRepository,
                           SessionRepository sessionRepository,
                           SheduleRepository sheduleRepository,
                           TherapyRepository therapyRepository,
                           TeamRepository teamRepository,
                           ContractRepository contractRepository) {
        this.patientRepository = patientRepository;
        this.sessionRepository = sessionRepository;
        this.sheduleRepository = sheduleRepository;
        this.therapyRepository = therapyRepository;
        this.teamRepository = teamRepository;
        this.contractRepository = contractRepository;

    }



    public Session registerSession(ClinicalEncounterDTO clinicalEncounterDTO, Jwt jwt){
        System.out.println(clinicalEncounterDTO.sscheduleId());
        SShedule shedule1 = this.sheduleRepository.getById(UUID.fromString(clinicalEncounterDTO.sscheduleId()));

        if(shedule1 == null){
            throw new RuntimeException("Sessao não registrada");
        }

        if(shedule1.getContract() == null || !shedule1.getContract().getStatus()){
            throw new RuntimeException("Contrato inativo ou inexistente");
        }
        System.out.println(jwt.getClaim("preferred_username").toString());
        if(!shedule1.getTherapist().getEmail().equals(jwt.getClaim("preferred_username"))){

        }
        Contract contract = this.contractRepository.getById(shedule1.getContract().getId());
        Session session = new Session();
        session.setShedule(shedule1);
        session.setDescription(clinicalEncounterDTO.description());
        session.setDate( clinicalEncounterDTO.date() != null ? clinicalEncounterDTO.date() : this.getDateBySessionEnum(shedule1.getSessionIdEnum()));
        session.setCreatedAt(Timestamp.from(Instant.now()));
        session.setUpdatedAt(Timestamp.from(Instant.now()));

        return this.sessionRepository.save(session);

    }

    private static final Map<String, DayOfWeek> DAYS_OF_WEEK = new HashMap<>();
    static {
        DAYS_OF_WEEK.put("SEG", DayOfWeek.MONDAY);
        DAYS_OF_WEEK.put("TER", DayOfWeek.TUESDAY);
        DAYS_OF_WEEK.put("QUA", DayOfWeek.WEDNESDAY);
        DAYS_OF_WEEK.put("QUI", DayOfWeek.THURSDAY);
        DAYS_OF_WEEK.put("SEX", DayOfWeek.FRIDAY);
        DAYS_OF_WEEK.put("SAB", DayOfWeek.SATURDAY);
        DAYS_OF_WEEK.put("DOM", DayOfWeek.SUNDAY);
    }

    private Timestamp getDateBySessionEnum(SessionIdEnum sessionIdEnum){


        String[] weekDayHour = sessionIdEnum.getValue().split("_");
        String week = weekDayHour[0];
        String hourStr = weekDayHour[1];
        DayOfWeek dayOfWeek = DAYS_OF_WEEK.get(week.toUpperCase());
        if (dayOfWeek == null) {
            throw new IllegalArgumentException("Dia da semana inválido: " + dayOfWeek);
        }

        // 3. Transforma "1300" em um objeto LocalTime (13:00)
        int hour = Integer.parseInt(hourStr.substring(0, 2));
        int minute = Integer.parseInt(hourStr.substring(2, 4));
        LocalTime localTime = LocalTime.of(hour, minute);

        // 4. Pega o momento atual com o fuso horário do sistema
        ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());

        // 5. Ajusta a data para a próxima ocorrência daquele dia da semana (ou hoje, se for o caso)
        ZonedDateTime dateTime = now.with(TemporalAdjusters.nextOrSame(dayOfWeek))
                .with(localTime)
                .withSecond(0)
                .withNano(0);

        return new Timestamp(dateTime.toInstant().toEpochMilli());
    }

    public List<Session> getSessions(){
        return this.sessionRepository.findAll();
    }

    public List<Session> getSessionsByContract(Contract contract){
        return this.sessionRepository.getSessionByContract(contract);
    }

    public List<SessionDTO> getByContract(String contractId) {
        Contract contract = this.contractRepository.getById(UUID.fromString(contractId));

        if(null == contract)
            throw new RuntimeException("Contrato não encontrado");

        return this.sessionRepository.getSessionDTOByContract(contract);
    }
}
