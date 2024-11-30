package com.start.pronto_recife.Mapper;


import com.start.pronto_recife.DTOs.ExamePacienteDTO;
import com.start.pronto_recife.Models.ExamePacienteModel;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExamePacienteMapper {

    ExamePacienteModel toModel(ExamePacienteDTO examePacienteDTO);
    ExamePacienteDTO toDTO(ExamePacienteModel examePacienteModel);
    List<ExamePacienteDTO> listEntitytoListDTO(List<ExamePacienteModel> listaexames);
}