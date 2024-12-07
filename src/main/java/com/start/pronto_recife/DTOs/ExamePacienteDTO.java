package com.start.pronto_recife.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record ExamePacienteDTO(@NotNull
                               LocalDate dataExame,
                               @NotNull @NotBlank
                               String resultado,
                               @NotNull @NotBlank
                               String nomeDoExame,
                               @NotNull @NotBlank
                               String consultaId) {
}


