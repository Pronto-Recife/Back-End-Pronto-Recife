package com.start.pronto_recife.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ExamePacienteDTO(@NotNull
                               LocalDate dataExame,
                               @NotNull @NotBlank
                               String resultado,
                               @NotNull @NotBlank
                               String nomeDoExame,
                               @NotNull @NotBlank
                               String pacienteId,
                               @NotNull @NotBlank
                               String consultaId
                               ) {

}


