package com.start.pronto_recife.DTOs;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.UUID;

public record DTOConsulta( UUID id,
                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
         LocalDate data_consulta,
         String tratamentos_prescritos,
         String instrucoes_recomendacoes,
         String sintomas,
        String historico_familiar
//        ,
//         UUID paciente_id,
//         UUID medico_id
)

        {
}
