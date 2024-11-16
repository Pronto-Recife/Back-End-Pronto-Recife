package com.start.pronto_recife.DTOs;
import java.time.LocalDate;
import java.util.UUID;

public record DTOConsulta( UUID id,
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
