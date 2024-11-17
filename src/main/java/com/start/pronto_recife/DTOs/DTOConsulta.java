package com.start.pronto_recife.DTOs;
import java.time.LocalDate;
import java.util.UUID;

public record DTOConsulta(
        LocalDate data_consulta,
        String tratamentos_prescritos,
        String instrucoes_recomendacoes,
        String sintomas,
        String historico_familiar
        ,
        String paciente_id,
        String medico_id,
        String laudos_id
)

{
}