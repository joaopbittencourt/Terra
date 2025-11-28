package com.house58.terra.schedule.dao;

import com.house58.terra.schedule.entity.Shedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface SheduleRepository extends JpaRepository<Shedule, UUID> {
    // JPQL (Java Persistence Query Language) query
    @Query("SELECT u FROM Shedule u WHERE u.team = %:team% and u.sessionIdEnum in (session) ")
    List<Shedule> findSheduleByTemAndSessionIdEnum(@Param("team") UUID teamId, @Param("session") String session);

    @Query("SELECT u FROM Shedule u WHERE u.contract = %:contract% u.team = %:team% and u.sessionIdEnum = %:session% and status = 1")
    Shedule findSheduleBySessionIdEnum(@Param("contract") UUID contractId, @Param("team") UUID teamId, @Param("session") String session);

}
