package com.house58.terra.schedule.service;

import com.house58.terra.contract.dao.ContractRepository;
import com.house58.terra.contract.dao.TherapyListRepository;
import com.house58.terra.contract.entity.CarePlan;
import com.house58.terra.contract.entity.Contract;
import com.house58.terra.contract.entity.TherapyList;
import com.house58.terra.patient.dao.PatientRepository;
import com.house58.terra.patient.dto.PatientDTO;
import com.house58.terra.patient.entity.Patient;
import com.house58.terra.schedule.dao.PatientRecordRepository;
import com.house58.terra.schedule.dao.SessionRepository;
import com.house58.terra.schedule.dao.SheduleRepository;
import com.house58.terra.schedule.dto.DataTherapyPatienteDTO;
import com.house58.terra.schedule.entity.Session;
import com.house58.terra.schedule.entity.Shedule;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import com.house58.terra.therapy.dao.TherapyRepository;
import com.house58.terra.therapy.entity.Therapy;
import com.house58.terra.user.dao.TeamRepository;
import com.house58.terra.user.entity.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RegisterShedule {

    private final PatientRepository patientRepository;
    private final SessionRepository sessionRepository;
    private final SheduleRepository sheduleRepository;
    private final TherapyListRepository therapyListRepository;
    private final TherapyRepository therapyRepository;
    private final TeamRepository teamRepository;
    private final ContractRepository  contractRepository;

    public RegisterShedule(PatientRepository patientRepository,
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

    public List<Shedule> register(Contract contract, List<DataTherapyPatienteDTO> dataTherapyPatienteDTOList, Date date){
        Patient patient = this.patientRepository.getById(contract.getPatient().getId());
        List<TherapyList> therapyLists = this.therapyListRepository.findAllById(this.returnIds(contract.getTherapyLists()));
        /*if(therapyLists.size() < sessionList.size()){
            throw new RuntimeException("Quantidade de sessões não liberada");
        }*/

        try {
            List<Shedule> sheduleList = new ArrayList<Shedule>();
            for(DataTherapyPatienteDTO dataTherapyPatienteDTO: dataTherapyPatienteDTOList){
                Contract contract1 = this.contractRepository.getById(contract.getId());
                Patient patient1 = this.patientRepository.getById(contract1.getPatient().getId());
                Team team = this.teamRepository.getById(dataTherapyPatienteDTO.getTeam().getId());
                Therapy therapy = this.therapyRepository.getById(dataTherapyPatienteDTO.getTherapy().getId());

                if(!team.getSessionsId().containsAll(dataTherapyPatienteDTO.getSessionList())){
                    throw new RuntimeException("Sessoes informadas indisponivel para o terapeuta");
                }

                if(!this.checkScheduleAvailability(team, dataTherapyPatienteDTO.getSessionList())){
                    throw new RuntimeException("Sessões ocupadas");
                }

                sheduleList.addAll(this.registerAllShedule(contract1, team, therapy, dataTherapyPatienteDTO.getSessionList()));

            }
            return  sheduleList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private Boolean checkScheduleAvailability(Team team, List<SessionIdEnum> sessionIdEnumList){
        List<Shedule> sheduleList = this.sheduleRepository.findSheduleByTemAndSessionIdEnum(team.getId(), sessionIdEnumList.toString());

        return sheduleList.size() > 0 ? false : true;
    }

    private List<Shedule> registerAllShedule(Contract contract, Team team, Therapy therapy, List<SessionIdEnum> sessionIdEnumList){
        List<Shedule> sheduleList = new ArrayList<Shedule>();
        for(SessionIdEnum sessionIdEnum :  sessionIdEnumList){
            Shedule shedule = this.factoryShedule(contract, therapy);
            shedule.setSessionIdEnum(sessionIdEnum);

            sheduleList.add(this.sheduleRepository.save(shedule));
        }
        return  sheduleList;
    }

    private Shedule factoryShedule(Contract contract, Therapy therapy){
        Shedule shedule = new Shedule();
        shedule.setContract(contract);
        shedule.setTherapy(therapy);
        return shedule;
    }


    private List<UUID> returnIds(List<TherapyList> therapyLists){
        List<UUID> ids = new ArrayList<UUID>();
        for(TherapyList t : therapyLists){

            ids.add(t.getId());
        }
        return ids;
    }

}
