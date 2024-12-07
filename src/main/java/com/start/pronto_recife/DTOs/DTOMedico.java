package com.start.pronto_recife.DTOs;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DTOMedico (@NotBlank @NotNull @Pattern(regexp = "^\\d{6}-[A-Z]{2}$", message = "O CRM deve estar no formato 123456-PE")
                         @Schema(example = "123456-PE")
                         String CRM,
                         @NotBlank @NotNull
                         String nomeCompleto,
                         @NotBlank @Pattern(regexp = "\\(81\\)9\\d{8}", message = "O número de telefone deve estar no formato (81)912345678")
                         @Schema(example = "(81)912345678")
                         String telefone,
                         @Email @NotBlank @NotNull
                         String email,
                         @NotNull @NotBlank
                         String senha) {


}
