package com.start.pronto_recife.DTOs;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DTOConsultaRequest(
        @NotNull  @JsonFormat(pattern="yyyy-MM-dd")
        LocalDate dataConsulta,
        @NotNull @NotBlank
        String tratamentosPrescritos,
        @NotNull @NotBlank
        String instrucoesRecomendacoes,
        @NotNull @NotBlank
        String sintomas,
        @NotNull @NotBlank
        String historicoFamiliar,
        String pacienteId,
        String medicoId
)

        {
}
