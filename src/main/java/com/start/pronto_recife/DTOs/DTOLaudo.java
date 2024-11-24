package com.start.pronto_recife.DTOs;

import jakarta.validation.constraints.NotBlank;

public record DTOLaudo(
        @NotBlank
        String descricao) {
}
