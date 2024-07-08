package com.house58.terra.patient.dao;

import com.house58.terra.patient.entity.Patient;
import com.house58.terra.patient.entity.Responsible;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponsibleRepository extends JpaRepository<Responsible, Integer> {

}
