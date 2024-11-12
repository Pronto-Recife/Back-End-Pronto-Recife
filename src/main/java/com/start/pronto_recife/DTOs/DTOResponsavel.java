package com.start.pronto_recife.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DTOResponsavel(@NotBlank @NotNull String nome_Completo,
                             @NotBlank String grau_Parentesco,
                             @NotNull LocalDate data_nascimento,
                             @NotBlank @NotNull @Pattern (regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}", message = "Telefone deve estar no formato (XX)XXXXX-XXXX")
                             String telefone,
                             @Email String email,
                             @NotBlank String genero) {
    public Object idResponsavel() {
        return null;
    }
}
