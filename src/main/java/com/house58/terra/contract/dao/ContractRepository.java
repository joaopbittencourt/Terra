package com.house58.terra.contract.dao;

import com.house58.terra.contract.entity.Contract;
import com.house58.terra.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface ContractRepository extends JpaRepository<Contract, UUID> {
    @Query("SELECT u FROM Contract u WHERE u.patient= :patient AND u.status = TRUE")
    List<Contract> findContractByPatient(@Param("patient") Patient patient);
}
