package com.house58.terra.contract.enumm

import lombok.Getter;

@Getter
enum class ContractStatus(description: String) {
    ACTIVE("Ativo"),

    SUSPENDED("Suspenso"),

    CANCELLED("Cancelado"),

    EXPIRED("Expirado"),

    PENDING_START("Aguardando Início"),

    PENDING_MEDICAL_GUIDE("Aguardando Guia Medica");

    private val description: String?

    init {
        this.description = description
    }
}