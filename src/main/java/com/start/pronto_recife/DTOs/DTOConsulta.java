package com.start.pronto_recife.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

<<<<<<< HEAD
import java.time.LocalDateTime; // Import correto para data e hora

public record DTOConsulta(
        @NotNull
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataConsulta,

=======
import java.time.LocalDate;
import java.time.LocalDateTime;

public record DTOConsulta(
        @NotNull  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataConsulta,
>>>>>>> 2d6e80ed13499512aa7f3f837757459543a64497
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
