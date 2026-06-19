package com.house58.terra.user.dao;

import com.house58.terra.schedule.enumm.SessionIdEnum;
import com.house58.terra.user.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {
    /*
    @Query("SELECT u.shedules FROM Team u WHERE u =:therapist")
    String findSesionIdEnumByTherapist(@Param("therapist") Team therapist);
    */
}
