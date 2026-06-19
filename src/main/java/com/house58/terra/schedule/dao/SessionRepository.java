package com.house58.terra.schedule.dao;

import com.house58.terra.contract.entity.Contract;
import com.house58.terra.schedule.dto.SessionDTO;
import com.house58.terra.schedule.entity.Session;
import jakarta.transaction.Transactional;
import jdk.jfr.Enabled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;
@EnableJpaRepositories
public interface SessionRepository extends JpaRepository<Session, UUID> {
    @Transactional
    @Query("SELECT new com.house58.terra.schedule.dto.SessionDTO(s.id, s.shedule.sessionIdEnum, s.date, s.shedule.therapy as therapy, s.shedule.therapist as therapist, s.status, s.description, s.createdAt, s.updatedAt) FROM session s where s.shedule.contract = :contract")
    List<SessionDTO> getSessionDTOByContract(Contract contract);

    @Query("SELECT s FROM session s where s.shedule.contract = :contract")
    List<Session> getSessionByContract(Contract contract);
}
