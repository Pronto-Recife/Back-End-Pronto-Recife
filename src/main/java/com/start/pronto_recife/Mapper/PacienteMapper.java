package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOPaciente;
import com.start.pronto_recife.Models.PacienteModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    PacienteModel toModel(DTOPaciente dtoPaciente);
    DTOPaciente toDTO(PacienteModel pacienteModel);
    List<DTOPaciente> listEntitytoListDTO(List<PacienteModel> pacientes);

}