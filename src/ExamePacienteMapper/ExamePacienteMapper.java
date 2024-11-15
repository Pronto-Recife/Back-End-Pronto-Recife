package com.start.pronto_recife.ExamePacienteMapper;

import com.start.pronto_recife.ExamePacienteMapper.ExamePaciente;
import com.start.pronto_recife.ExamePacienteMapper.ExamePacienteDTO;
import com.start.pronto_recife.ExamePacienteDTO.ExamePacienteDTO;

public interface ExamePacienteMapper {

	ExamePacienteDTO toDTO(ExamePaciente model);

    ExamePaciente toModel(ExamePacienteDTO dto);
}
