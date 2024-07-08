package com.house58.terra.schedule.dao;

import com.house58.terra.schedule.entity.PatientRecord;
import com.house58.terra.schedule.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRecordRepository extends JpaRepository<PatientRecord, Long> {
}
