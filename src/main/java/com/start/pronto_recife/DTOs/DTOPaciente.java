package com.start.pronto_recife.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record DTOPaciente(
                          @NotNull @NotBlank @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato 123.456.789-10")
                          String CPF,

                          String estadoCivil,

                          @NotNull @NotBlank
                          String nomeCompleto,

                          @NotNull
                          LocalDate dataNascimento,

                          String genero,

                          @NotNull @NotBlank @Email
                          String email,

                          @NotNull @NotBlank
                          String senha,

                          @NotNull @NotBlank
                          String telefone,

                          String contatoRepresentante,

                          String endereco,

                          // Responsável pode ser mapeado em outro DTO, se necessário
                          String responsavelId){

}
