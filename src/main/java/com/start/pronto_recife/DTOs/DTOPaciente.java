package com.start.pronto_recife.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.UUID;

public record DTOPaciente(UUID id,
                          @NotBlank @Pattern(regexp = "\\d{11}")
                          String CPF,
                          @NotBlank
                          String nome_completo,
                          @NotBlank
                          LocalDate data_nascimento,
                          @NotBlank
                          String genero,
                          @NotBlank @Email
                          String email,
                          @NotBlank @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}", message = "Telefone deve estar no formato (XX)XXXXX-XXXX")
                          String telefone,
                          String contato_representante,
                          @NotBlank
                          String cep,
                          @NotBlank
                          String endereço,
                          @Pattern(regexp = "\\d{11}")
                          String responsavel_CPF) {
}
