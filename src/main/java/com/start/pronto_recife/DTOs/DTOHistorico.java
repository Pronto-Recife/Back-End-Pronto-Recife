package com.start.pronto_recife.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTOHistorico(

                           @NotNull @NotBlank
                           String cirurgias_anteriores,
                           String pacienteId) {


}