package com.start.pronto_recife.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DTOEstabelecimento(@NotNull @NotBlank @Pattern(regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$", message = "O COREN deve estar no formato 12.345.678/0001-95")
                                 @Schema(example = "12.345.678/0001-95")
                                 String cnpj,
                                 @NotNull @NotBlank
                                 String nome,
                                 @NotNull @NotBlank
                                 String endereco,
                                 @NotBlank @NotNull @Pattern(regexp = "\\(81\\)9\\d{8}", message = "O número de telefone deve estar no formato (81)912345678")
                                 @Schema(example = "(81)912345678")
                                 String telefone,
                                 @NotBlank @NotNull @Email
                                 String email,
                                 @NotBlank @NotNull
                                 String senha

) {
}
