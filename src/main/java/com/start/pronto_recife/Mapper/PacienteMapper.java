package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOPaciente;
import com.start.pronto_recife.Models.PacienteModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    @Mapping(source = "data_nascimento", target = "data_nascimento")
    PacienteModel toModel(DTOPaciente dtoPaciente);
    @Mapping(source = "data_nascimento", target = "data_nascimento")
    DTOPaciente toDTO(PacienteModel pacienteModel);
    List<DTOPaciente> listEntitytoListDTO(List<PacienteModel> pacientes);

}
