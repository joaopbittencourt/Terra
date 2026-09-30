package com.house58.terra.finance.service;

import com.house58.terra.finance.dao.MovementOutputRepository;
import com.house58.terra.finance.entity.MovementOutput;
import com.house58.terra.finance.enumm.PaymentMethodEnum;
import com.house58.terra.patient.entity.Patient;
import com.house58.terra.user.entity.Team;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
@Service
public class MakePayment {

    private final MovementOutputRepository movementOutputRepository;

    public MakePayment(MovementOutputRepository movementOutputRepository) {
        this.movementOutputRepository = movementOutputRepository;
    }

    private MovementOutput registerMovement(Team team, Double value, PaymentMethodEnum paymentMethodEnum, Jwt jwt){
        MovementOutput movementOutput1 = new MovementOutput();
        //PONTO DE ATENÇÃ0, VERIFIQUE PARA GARANTIR QUE SEMPRE ESTAR RETORNANDO O CONTRATO ATIVO
        movementOutput1.setTeam(team);
        movementOutput1.setValue(value);
        movementOutput1.setDescription("Pagamento de honorarios: "+team.getName());
        movementOutput1.setUser(jwt.getClaim("preferred_username").toString());
        movementOutput1.setCreatedAt(Timestamp.from(Instant.now()));

        return this.movementOutputRepository.save(movementOutput1);
    }
}
