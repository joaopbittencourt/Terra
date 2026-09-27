package com.house58.terra.patient.dao;

import com.house58.terra.patient.entity.MedicalGuide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicalGuideRepository extends JpaRepository<MedicalGuide, UUID> {
}
