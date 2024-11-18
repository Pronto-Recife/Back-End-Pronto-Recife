package com.start.pronto_recife.Mapper;


import com.start.pronto_recife.DTOs.ExamePacienteDTO;
import com.start.pronto_recife.Models.ExamePacientModel;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExamePacienteMapper {

    ExamePacientModel toModel( ExamePacienteDTO examePacienteDTO);
    ExamePacienteDTO toDTO(ExamePacientModel examePacientModel);
    List<ExamePacienteDTO> listEntitytoListDTO(List<ExamePacientModel> listaexames);
}
