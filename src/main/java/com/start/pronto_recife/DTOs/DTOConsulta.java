package com.start.pronto_recife.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DTOConsulta(
        @NotNull  @JsonFormat(pattern="yyyy-MM-dd")
        LocalDate dataConsulta,
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
        String laudoId)
        {

        }
