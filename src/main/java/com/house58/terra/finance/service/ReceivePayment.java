package com.house58.terra.finance.service;

import com.house58.terra.finance.dao.MovementInputRepository;
import com.house58.terra.finance.entity.MovementInput;
import com.house58.terra.finance.enumm.PaymentMethodEnum;
import com.house58.terra.patient.entity.Patient;
import org.springframework.security.oauth2.jwt.Jwt;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

public class ReceivePayment {
    private final MovementInputRepository movementInputRepository;

    public ReceivePayment(MovementInputRepository movementInputRepository) {
        this.movementInputRepository = movementInputRepository;
    }

    private MovementInput registerMovemenmt(Patient patient, Double value, PaymentMethodEnum paymentMethodEnum, Jwt jwt){
        MovementInput movementInput1 = new MovementInput();
        //PONTO DE ATENÇÃ0, VERIFIQUE PARA GARANTIR QUE SEMPRE ESTAR RETORNANDO O CONTRATO ATIVO
        movementInput1.setContract(patient.getContracts().getFirst());
        movementInput1.setValue(value);
        movementInput1.setDescription("Pagamento por atendimentos: "+patient.getFirstName());
        movementInput1.setUser(jwt.getClaim("preferred_username").toString());
        movementInput1.setCreatedAt(Timestamp.from(Instant.now()));

        return this.movementInputRepository.save(movementInput1);
    }
}
