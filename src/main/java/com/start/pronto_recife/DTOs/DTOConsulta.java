package com.start.pronto_recife.DTOs;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record DTOConsulta(
        @NotNull @NotBlank
        LocalDate data_consulta,
        @NotNull @NotBlank
        String tratamentos_prescritos,
        @NotNull @NotBlank
        String instrucoes_recomendacoes,
        @NotNull @NotBlank
        String sintomas,
        @NotNull @NotBlank
        String historico_familiar,
        @NotNull @NotBlank
        String paciente_id,
        @NotNull @NotBlank
        String medico_id,
        @NotNull @NotBlank
        String laudos_id
)

{
}