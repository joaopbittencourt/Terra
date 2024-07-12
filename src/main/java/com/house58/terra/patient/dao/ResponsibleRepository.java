package com.house58.terra.patient.dao;

import com.house58.terra.patient.entity.Responsible;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResponsibleRepository extends JpaRepository<Responsible, UUID> {

}
