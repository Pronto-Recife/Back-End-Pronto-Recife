package com.start.pronto_recife.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
import java.util.List;

public record DTOAgenda(

        @NotNull
        UUID id,

        @NotNull
        LocalDate data,

        @NotNull
        LocalTime time,

        @NotNull
        DTOMedico medicoModel,

        @NotNull
        List<DTOPaciente> pacienteModels,

        @NotBlank
        String status,

        String observacoes
) {
}
