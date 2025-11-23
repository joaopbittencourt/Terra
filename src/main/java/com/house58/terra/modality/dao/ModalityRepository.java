package com.house58.terra.modality.dao;

import com.house58.terra.modality.entity.Modality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModalityRepository extends JpaRepository<Modality, UUID> {
}
