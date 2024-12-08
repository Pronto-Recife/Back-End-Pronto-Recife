package com.start.pronto_recife.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DTOPaciente(
        @NotNull @NotBlank @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato 123.456.789-10")
        String CPF,
        @NotNull @NotBlank
        String nomeCompleto,
        @NotNull
        @JsonFormat(pattern="yyyy-MM-dd")
        LocalDate dataNascimento,
        @NotBlank
        String genero,
        @NotBlank @NotNull @Email
        String email,
        @NotBlank @NotNull
        String senha,
        @NotBlank @Pattern(regexp = "\\(81\\)9\\d{8}", message = "O número de telefone deve estar no formato (81)912345678")
        @Schema(example = "(81)912345678")
        String telefone,
        @Pattern(regexp = "\\(81\\)9\\d{8}", message = "O número de telefone deve estar no formato (81)912345678")
        @Schema(example = "(81)912345678")
        String contatoRepresentante,
        @NotNull @NotBlank@Pattern(regexp = "^\\d{5}-\\d{3}$", message = "O CEP deve estar no formato 12345-678")
        @NotBlank
        String endereco,
        String alergia,
        String condicoesCronicas,
        String responsavelCpf
        ){


}
