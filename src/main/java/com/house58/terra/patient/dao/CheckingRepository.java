package com.house58.terra.patient.dao;

import com.house58.terra.patient.entity.Checking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CheckingRepository extends JpaRepository<Checking, UUID> {

}
