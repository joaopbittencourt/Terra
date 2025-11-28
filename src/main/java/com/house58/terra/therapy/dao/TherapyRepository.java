package com.house58.terra.therapy.dao;

import com.house58.terra.therapy.entity.Therapy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TherapyRepository extends JpaRepository<Therapy, UUID> {

}
