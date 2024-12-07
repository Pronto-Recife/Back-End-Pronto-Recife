package com.start.pronto_recife.DTOs;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.start.pronto_recife.Models.ExamePacienteModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record DTOConsulta(
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
        @NotNull @NotBlank
        String pacienteId,
        @NotNull @NotBlank
        String medicoId,
        List<ExamePacienteModel> exame
)

        {
}
