package com.start.pronto_recife.DTOs;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DTOMedico (@NotBlank @Pattern(regexp = "\\d{4,10}")
                         String CRM,

                         @NotBlank
                         String nome_completo,

                         String especialidade,

                         @NotBlank @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}", message = "Telefone deve estar no formato (XX)XXXXX-XXXX")
                         String telefone,

                         @Email
                         String email) {


}
