package com.house58.terra.patient.entity;

import com.house58.terra.patient.enumm.GuideStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "medical_guides")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalGuide {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String guideNumber; // Número da guia na operadora

    private String authorizationCode; // Senha autorizada

    @Column(nullable = false)
    private LocalDate expirationDate;

    // Controle de sessões para terapias recorrentes
    @Column(nullable = false)
    private Integer totalSessionsAuthorized;

    @Column(nullable = false)
    private Integer usedSessions = 0;

    @Enumerated(EnumType.STRING)
    private GuideStatus status = GuideStatus.ACTIVE;

    /*
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "guide_id")
    private List<GuideItem> items = new ArrayList<>();
    */
    // --- Regras de Negócio (Rich Domain) ---

    public boolean isExpired() {
        return LocalDate.now().isAfter(this.expirationDate);
    }

    public boolean hasAvailableSessions() {
        return this.usedSessions < this.totalSessionsAuthorized;
    }

    public boolean isValid() {
        return status == GuideStatus.ACTIVE && !isExpired() && hasAvailableSessions();
    }

    /**
     * Debita uma sessão da guia.
     * Ideal para ser chamado no momento do check-in ou finalização do atendimento.
     */
    public void consumeSession() {
        if (!isValid()) {
            throw new IllegalStateException("Guia inválida para consumo: expirada, sem saldo ou inativa.");
        }
        this.usedSessions++;

        if (this.usedSessions.equals(this.totalSessionsAuthorized)) {
            this.status = GuideStatus.EXHAUSTED;
        }
    }
}