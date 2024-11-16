package com.start.pronto_recife.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public record DTOEstabelecimento(UUID id,
                                 @NotNull @NotBlank
                                 String nome,
                                 @NotNull @NotBlank
                                 String endereco,
                                 @NotNull @NotBlank @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}", message = "Telefone deve estar no formato (XX)XXXXX-XXXX")
                                 String telefone,
                                 @NotBlank @Email
                                 String email) {
}
