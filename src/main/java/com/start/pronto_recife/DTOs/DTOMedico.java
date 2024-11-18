package com.start.pronto_recife.DTOs;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DTOMedico (@NotBlank @NotNull @Pattern(regexp = "\\d{15}")
                         String CRM,

                         @NotBlank @NotNull
                         String nome_completo,

                         @NotNull
                         String especialidade,

                         @NotBlank @NotNull @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}", message = "Telefone deve estar no formato (XX)XXXXX-XXXX")
                         String telefone,
                         @Email
                         String email,
                         @NotBlank @NotNull
                         String senha) {


}
