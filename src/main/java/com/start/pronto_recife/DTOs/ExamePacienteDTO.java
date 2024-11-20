package com.start.pronto_recife.DTOs;

import java.time.LocalDate;
import java.util.UUID;

public record ExamePacienteDTO(UUID id,
                               LocalDate dataExame,
                               String resultado,
                               String nomeDoExame)
//        UUID pacienteId,
//        UUID consultaId)
{


}


