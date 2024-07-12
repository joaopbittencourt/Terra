package com.house58.terra.schedule.dao;

import com.house58.terra.schedule.entity.PatientRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRecordRepository extends JpaRepository<PatientRecord, UUID> {
}
