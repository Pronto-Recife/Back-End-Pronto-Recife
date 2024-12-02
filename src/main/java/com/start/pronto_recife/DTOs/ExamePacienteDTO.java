package com.start.pronto_recife.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record ExamePacienteDTO(@NotNull @NotBlank
                               LocalDate dataExame,
                               @NotNull @NotBlank
                               String resultado,
                               @NotNull @NotBlank
                               String nomeDoExame,
                               @NotNull @NotBlank @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato 123.456.789-10")
                               String pacienteCPF,
                               @NotNull @NotBlank
                               String consultaId) {
}


