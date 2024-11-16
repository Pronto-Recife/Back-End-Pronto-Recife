package com.start.pronto_recife.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DTOLaudo(
        @NotNull
        UUID id,

        @NotBlank
        String descricao) {
}
