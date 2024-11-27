package com.start.pronto_recife.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DTOAgenteSaude(
        @NotNull @NotBlank @Pattern
        (regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato 123.456.789-10")
        String CPF,
    @NotNull @NotBlank
 String nome,
     @NotNull @NotNull
 String senha,
     @NotNull @NotBlank @Pattern
      (regexp = "\\(81\\)9\\d{8}", message = "O número de telefone deve estar no formato (81)912345678")
         @Schema(example = "(81)912345678")
   String telefone,
     @Email @NotBlank
 String email){
}
