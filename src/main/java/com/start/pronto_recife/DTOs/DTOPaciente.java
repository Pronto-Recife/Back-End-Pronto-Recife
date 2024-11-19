package com.start.pronto_recife.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

public record DTOPaciente(
                          @NotNull @NotBlank @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato 123.456.789-10")
                          String CPF,
                          @NotNull @NotBlank
                          String nome_completo,
                          @NotNull
                          @JsonFormat(pattern="yyyy-MM-dd")
                          LocalDate data_nascimento,
                          @NotNull @NotBlank
                          String genero,
                          @NotBlank @Email
                          String email,
                          @NotBlank @NotNull
                          String senha,
                          @NotNull @NotBlank @Pattern(regexp = "\\(81\\)9\\d{8}", message = "O número de telefone deve estar no formato (81)912345678")
                          @Schema(example = "(81)912345678")
                          String telefone,
                          @NotNull @NotBlank @Pattern(regexp = "\\(81\\)9\\d{8}", message = "O número de telefone deve estar no formato (81)912345678")
                          @Schema(example = "(81)912345678")
                          String contato_representante,
                          @NotNull @NotBlank@Pattern(regexp = "^\\d{5}-\\d{3}$", message = "O CEP deve estar no formato 12345-678")
                          @Schema(example = "12345-678")
                          String cep,
                          @NotNull @NotBlank
                          String endereco,
                          @NotNull @NotBlank @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato 123.456.789-10")
                          String responsavel_CPF){

}
