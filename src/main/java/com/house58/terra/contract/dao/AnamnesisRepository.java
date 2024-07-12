package com.house58.terra.contract.dao;

import com.house58.terra.patient.entity.Anamnesis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnamnesisRepository extends JpaRepository<Anamnesis, UUID> {
}
