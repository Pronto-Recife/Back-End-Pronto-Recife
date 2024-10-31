package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOPaciente;
import com.start.pronto_recife.Models.PacienteModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    PacienteModel toModel(DTOPaciente dtoPaciente);
    DTOPaciente toDTO(PacienteModel pacienteModel);
    List<DTOPaciente> listEntitytoListDTO(List<PacienteModel> pacientes);
}
