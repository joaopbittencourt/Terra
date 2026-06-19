package com.house58.terra.patient.dao;

import com.house58.terra.patient.entity.Guardians;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface GuardianRepository extends JpaRepository<Guardians, UUID> {
    @Query("SELECT g FROM guardians g WHERE g.cpf =:cpf ")
    Guardians findGuardianByCpf(@Param("cpf") Long cpf);
}
