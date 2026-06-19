package com.house58.terra.patient.enumm;

public enum GuideStatus {
    ACTIVE,      // Pronto para uso
    EXHAUSTED,   // Saldo de sessões zerado
    EXPIRED,     // Data de validade ultrapassada
    CANCELLED,   // Cancelada pela operadora ou clínica
    BILLED       // Já enviada no lote de faturamento (XML TISS)
}