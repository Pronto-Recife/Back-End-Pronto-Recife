package com.start.pronto_recife.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.UUID;

import java.time.LocalDate;

public record DTOResponsavel(
                            @NotBlank @NotNull String nomeCompleto,
                             @NotBlank String grauParentesco,
                             @NotNull @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
                             LocalDate dataNascimento,
                             @NotBlank @NotNull @Pattern (regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}", message = "Telefone deve estar no formato (XX)XXXXX-XXXX")
                             String telefone,
                             @Email String email,
                             @NotBlank String genero) {
//    public Object id()
//    {
//        return null;
//    }
}
