package com.house58.terra.schedule.dao;

import com.house58.terra.schedule.entity.SShedule;
import com.house58.terra.schedule.enumm.SessionIdEnum;
import com.house58.terra.user.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@EnableJpaRepositories
public interface SheduleRepository extends JpaRepository<SShedule, UUID> {
        // JPQL (Java Persistence Query Language) query
    @Query("SELECT u FROM SShedule u WHERE u.therapist = %:therapist% and u.sessionIdEnum in (%:session%) and status= true ")
    List<SShedule> findSheduleByTherapistSessionIdEnum(@Param("therapist") Team therapist, @Param("session") List<SessionIdEnum> session);
    @Query("SELECT u FROM SShedule u WHERE u.therapist = :therapist ")
    List<SShedule> findSheduleByTherapist(@Param("therapist") Team therapist);

    @Query("SELECT u FROM SShedule u WHERE u.status = true ")
    List<SShedule> findSheduleActive();

    @Query("SELECT u FROM SShedule u WHERE u.contract = %:contract% and u.therapy = %:therapy% and u.sessionIdEnum = %:session% ")
    SShedule findSheduleBySessionIdEnum(@Param("contract") UUID contractId, @Param("therapy") UUID therapyId, @Param("session") String session);

    @Query("SELECT u FROM SShedule u  WHERE u.contract.id = %:contract% ")
    List<SShedule> getByContract(@Param("contract") UUID contract);

    @Query("SELECT u FROM SShedule u  WHERE u.contract.id = %:contract% AND u.status= true ")
    List<SShedule> getByContractSheduleActive(@Param("contract") UUID contract);

    @Modifying
    @Transactional
    @Query("UPDATE SShedule u SET u.status = false WHERE u.sessionIdEnum in (%:sessionIdEnumList%) and u.therapist = %:therapist% ")
    void removeSchedulesByTeam(@Param("therapist")Team therapist, @Param("sessionIdEnumList") List<String> sessionIdEnumList);
}
