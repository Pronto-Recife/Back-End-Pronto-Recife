package com.start.pronto_recife.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

public record DTOPaciente(UUID id,
                          @NotNull @NotBlank @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato ###.###.###-##")
                          String CPF,
                          @NotNull @NotBlank
                          String nome_completo,
                          @NotNull @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
                          LocalDate data_nascimento,
                          @NotNull @NotBlank
                          String genero,
                          @NotBlank @Email
                          String email,
                          @NotBlank @NotNull
                          String senha,
                          @NotNull @NotBlank @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}", message = "Telefone deve estar no formato (XX)XXXXX-XXXX")
                          String telefone,
                          @NotBlank @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}", message = "Telefone deve estar no formato (XX)XXXXX-XXXX")
                          String contato_representante,
                          @NotNull @NotBlank
                          String cep,
                          @NotNull @NotBlank
                          String endereco,
                          @Min(14) @Max(14)
                          String responsavel_CPF){
}