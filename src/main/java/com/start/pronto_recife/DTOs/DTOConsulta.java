package com.start.pronto_recife.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime; // Import correto para data e hora

public record DTOConsulta(
        @NotNull
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataConsulta,

        @NotNull
        String tratamentosPrescritos,

        @NotNull
        String instrucoesRecomendacoes,

        @NotNull
        String sintomas,

        @NotNull
        String historicoFamiliar,

        String condicoesGerais,
        String diagnostico,
        String pacienteId,
        String medicoId,
        String laudoId
) {
}
