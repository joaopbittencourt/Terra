package com.house58.terra.contract.dao;

import com.house58.terra.patient.entity.Anamnesis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnamnesisRepository extends JpaRepository<Anamnesis, Integer> {
}
