package com.house58.terra.contract.dao;

import com.house58.terra.contract.entity.Modaliity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModalityRepository extends JpaRepository<Modaliity, UUID> {
}
