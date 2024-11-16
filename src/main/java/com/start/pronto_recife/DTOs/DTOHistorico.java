package com.start.pronto_recife.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DTOHistorico(UUID id,
//                           String nomePaciente,
//                           String dataConsulta,
//                           String diagnostico,
//                           String medicamentosPrescritos,
//                           String observacoes,
                           @NotNull @NotBlank
                           String cirurgias_anteriores,
                           @NotNull @NotBlank
                           String condicoes_gerais) {
}