package com.start.pronto_recife.DTOs;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DTOMedico (@NotBlank @NotNull @Pattern(regexp = "\\d{4,10}")
                         String CRM,

                         @NotBlank @NotNull
                         String nome_completo,

                         String especialidade,

                         @NotBlank @NotNull
                         String telefone,

                         @Email
                         String email) {


}
