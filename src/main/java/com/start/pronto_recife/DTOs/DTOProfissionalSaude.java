package com.start.pronto_recife.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DTOProfissionalSaude(
        @NotNull @NotBlank @Pattern
        (regexp = "COREN-(AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|PA|RO|RR|SC|SE|SP|TO|PR)-\\d{3}\\.\\d{3}-(ENF|TE|AE|OBST|PAR)",
         message = "COREN deve estar no formato COREN-UF-123.456-CAT, " +
                  "onde UF é uma unidade federativa válida e CAT é uma das categorias ENF, TE, AE, OBST ou PAR")
        String coren,
        @NotNull @NotBlank
        String nome,
        @NotNull
        String senha,
        @NotNull @NotBlank @Pattern
        (regexp = "\\(81\\)9\\d{8}", message = "O número de telefone deve estar no formato (81)912345678")
        @Schema(example = "(81)912345678")
        String telefone,
        @Email @NotBlank
        String email,
        String idEstabelecimento) {
}
