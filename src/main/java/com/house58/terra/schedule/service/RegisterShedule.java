package com.house58.terra.schedule.service;

import com.house58.terra.contract.dao.ContractRepository;
import com.house58.terra.contract.dao.MonthlyContractRepository;
import com.house58.terra.contract.entity.Contract;
import com.house58.terra.contract.entity.MonthlyContract;
import com.house58.terra.contract.entity.TherapyList;
import com.house58.terra.contract.enumm.ContractStatus;
import com.house58.terra.patient.dao.PatientRepository;
import com.house58.terra.patient.entity.Patient;
import com.house58.terra.schedule.dao.SessionRepository;
import com.house58.terra.schedule.dao.SheduleRepository;
import com.house58.terra.schedule.dto.DataTherapyPatienteDTO;
import com.house58.terra.schedule.dto.ScheduleDTO;
import com.house58.terra.schedule.entity.SShedule;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import com.house58.terra.therapy.dao.TherapyRepository;
import com.house58.terra.therapy.entity.Therapy;
import com.house58.terra.user.dao.TeamRepository;
import com.house58.terra.user.entity.Team;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class RegisterShedule {

    private final PatientRepository patientRepository;
    private final SessionRepository sessionRepository;
    private final SheduleRepository sheduleRepository;
    private final TherapyRepository therapyRepository;
    private final TeamRepository teamRepository;
    private final ContractRepository  contractRepository;
    private final MonthlyContractRepository monthlyContractRepository;

    public RegisterShedule(PatientRepository patientRepository,
                           SessionRepository sessionRepository,
                           SheduleRepository sheduleRepository,
                           TherapyRepository therapyRepository,
                           TeamRepository teamRepository,
                           ContractRepository contractRepository,
                           MonthlyContractRepository monthlyContractRepository) {
        this.patientRepository = patientRepository;
        this.sessionRepository = sessionRepository;
        this.sheduleRepository = sheduleRepository;
        this.therapyRepository = therapyRepository;
        this.teamRepository = teamRepository;
        this.contractRepository = contractRepository;
        this.monthlyContractRepository = monthlyContractRepository;
    }

    public List<SShedule> register(
            String contract,
            List<DataTherapyPatienteDTO>
            dataTherapyPatienteDTOList){
        Contract contract1 = this.contractRepository.getById(UUID.fromString(contract));


        Patient patient = contract1.getPatient();

        try {
            List<SShedule> sheduleList = new ArrayList<SShedule>();
            List<SShedule> sheduleListNow = this.sheduleRepository.getByContract(contract1.getId());
            List<SShedule> sheduleListNowFiltred = new ArrayList<>();
            List<Therapy> therapyList = new ArrayList<Therapy>();

            for(DataTherapyPatienteDTO dataTherapyPatienteDTO: dataTherapyPatienteDTOList){
                Team team = this.teamRepository.getById(UUID.fromString(dataTherapyPatienteDTO.getTherapist()));
                Therapy therapy = this.therapyRepository.getById(UUID.fromString(dataTherapyPatienteDTO.getTherapy()));

                if(null != team.getSessionsId() && !team.getSessionsId().containsAll(dataTherapyPatienteDTO.getSessionArrayList())){
                    //throw new RuntimeException("Sessoes informadas indisponivel para o terapeuta");
                }

                if(!this.checkScheduleAvailability(team,this.convertStringToEnum(dataTherapyPatienteDTO.getSessionArrayList()),contract1)){
                    //throw new RuntimeException("Sessões ocupadas");
                }

                therapyList.add(therapy);
                sheduleListNowFiltred.addAll(this.factoryListSheduleRepeat(dataTherapyPatienteDTO.getSessionArrayList(), sheduleListNow.stream().filter(sh ->  sh.getTherapist().equals(team)).toList()));
                if(sheduleListNowFiltred.isEmpty())
                    throw new RuntimeException("Lista antiga não filtrada");
                sheduleList.addAll(
                        this.factoryListAllShedule(
                                contract1,
                                team,
                                therapy,
                                dataTherapyPatienteDTO.getSessionArrayList(),
                                sheduleListNowFiltred));

            }

            contract1.setTherapyLists(therapyList);
            contract1.getPatient().setStatus(true);
            contract1.setStatus(true);
           // MonthlyContract monthlyContract = this.factoryMonthlyContract(contract, monthlyContractDTO.getMonthlyValue(),monthlyContractDTO.getBillingDay(), therapyList.size());

            this.contractRepository.save(contract1);
            //this.monthlyContractRepository.save(monthlyContract);

            List<SShedule> list = this.sheduleRepository.saveAll(sheduleList) ;

            this.sheduleRepository.saveAll(sheduleListNowFiltred.stream().peek(s -> {
                s.setUpdatedAt(Timestamp.from(Instant.now()));
                s.setStatus(false);
                System.out.println(s);
            }).toList());

            return  list;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<SShedule> getSchedule(){
        return this.sheduleRepository.findSheduleActive();
    }

    public  List<SShedule> getActiveSchedule(){
        return this.sheduleRepository.findSheduleActive();
    }

    public List<ScheduleDTO> getScheduleOrientedPeerTherapist(String contractId){

        //POR FAVOR CONSERTE ISSO POSTERIORMENTE
        Contract contract = this.contractRepository.getById(UUID.fromString(contractId));
        if(contract == null)
            throw new RuntimeException("Contrato não encontrado");

        List<SShedule> scheduleList = this.sheduleRepository.getByContract(contract.getId());
        List<ScheduleDTO> scheduleDTOList = new ArrayList<ScheduleDTO>();
        List<ScheduleDTO> scheduleDTOListAUX = new ArrayList<ScheduleDTO>();
        int indexOf;

        for(SShedule shedule : scheduleList) {
            if (shedule.getStatus()) {

                indexOf = -1;
                ScheduleDTO scheduleDTO = new ScheduleDTO();
                scheduleDTO.setTherapistId(shedule.getTherapist().getId());
                scheduleDTO.setTherapyId(shedule.getTherapy().getId());
                List<SessionIdEnum> sessionIdEnumList = new ArrayList<SessionIdEnum>();
                if (scheduleDTOListAUX.size() == 0) {
                    scheduleDTOListAUX.add(scheduleDTO);
                } else {
                    indexOf = scheduleDTOListAUX.indexOf(scheduleDTO);
                    if (indexOf != -1) {
                        sessionIdEnumList = scheduleDTO.getSessionIdEnumList();
                    } else {
                        scheduleDTOListAUX.add(scheduleDTO);
                    }
                }
                sessionIdEnumList.add(shedule.getSessionIdEnum());
                scheduleDTO.setSessionIdEnumList(sessionIdEnumList);
                if (indexOf != -1) {
                    scheduleDTOList.set(indexOf, scheduleDTO);
                } else {
                    scheduleDTOList.add(scheduleDTO);
                }
            }
        }

        return scheduleDTOList;
    }

    private Boolean checkScheduleAvailability( Team team, List<SessionIdEnum> sessionIdEnumList, Contract contract){
        List<SShedule> sheduleList = this.sheduleRepository.findSheduleByTherapistSessionIdEnum(team, sessionIdEnumList);

        long scheduleCount = sheduleList.stream().map(SShedule::getContract).filter(
                contract1 ->
                    contract1.getId().equals(contract.getId())).count();

        return scheduleCount <= 0;
    }

    private MonthlyContract factoryMonthlyContract(Contract contract, BigDecimal monthlyValue, Integer billingDay, Integer weeklyFrequency){
        MonthlyContract monthlyContract =  new MonthlyContract();
        monthlyContract.setContract(contract);
        monthlyContract.setBillingDay(billingDay);
        monthlyContract.setStartDate(Timestamp.from(Instant.now()));
        monthlyContract.setStatus(ContractStatus.ACTIVE);
        monthlyContract.setMonthlyValue(monthlyValue);
        return monthlyContract;
    }

    private List<SShedule> factoryListAllShedule(Contract contract, Team team, Therapy therapy, List<String> sessionIdEnumList, List<SShedule> sheduleListNow){
        List<SShedule> sheduleList = new ArrayList<SShedule>();

        for(String sessionIdEnum :  sessionIdEnumList){
            sheduleList.add(this.factoryShedule(contract, therapy, team, SessionIdEnum.fromValue(sessionIdEnum)));
        }

        sheduleList.removeAll(sheduleListNow);

        return  sheduleList;
    }

    private List<SShedule> factoryListSheduleRepeat(List<String> sessionIdEnumList, List<SShedule> sheduleListNow) {
        List<SShedule> listScheduleFilter = new ArrayList<>();
        int index = 0;
        for (String sessionIdEnum : sessionIdEnumList) {
            List<SShedule> sheduleListRepeat = sheduleListNow.stream().filter(s -> {
                System.out.println(s.getSessionIdEnum()+" == "+SessionIdEnum.fromValue(sessionIdEnum));
                return s.getSessionIdEnum() == SessionIdEnum.fromValue(sessionIdEnum);
            }).toList();

            if (sheduleListRepeat.isEmpty())
                listScheduleFilter.addAll(sheduleListRepeat);

        }
        return listScheduleFilter;
    }

    private SShedule factoryShedule(Contract contract, Therapy therapy, Team therapist, SessionIdEnum sessionIdEnum){
        SShedule shedule = new SShedule();
        shedule.setContract(contract);
        shedule.setTherapy(therapy);
        shedule.setTherapist(therapist);
        shedule.setSessionIdEnum(sessionIdEnum);
        shedule.setStatus(true);
        shedule.setCreatedAt(Timestamp.from(Instant.now()));
        return shedule;
    }


    private List<UUID> returnIds(List<TherapyList> therapyLists){
        List<UUID> ids = new ArrayList<UUID>();
        for(TherapyList t : therapyLists){

            ids.add(t.getId());
        }
        return ids;
    }

    private List<SessionIdEnum> convertStringToEnum( List<String> sessionListString){
        List<SessionIdEnum> list = new ArrayList<>();

        for(String sessionString : sessionListString){
            list.add(SessionIdEnum.fromValue(sessionString));
        }

        return list;
    }

    public List<SShedule> getByContract(String contractId) {
        Contract contract = this.contractRepository.getById(UUID.fromString(contractId));

        if(null == contract) {
            throw new RuntimeException("Contrato não encontrado");
        }

        return this.sheduleRepository.getByContract(contract.getId());
    }
}
