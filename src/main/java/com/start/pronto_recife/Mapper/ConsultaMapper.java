package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOConsulta;
import com.start.pronto_recife.DTOs.DTOPaciente;
import com.start.pronto_recife.Models.ConsultaModel;
import com.start.pronto_recife.Models.PacienteModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {
    ConsultaModel toModel(DTOConsulta dtoconsulta);
    DTOConsulta toDTO(ConsultaModel consultaModel);
    List<DTOConsulta> listModeltoListDTO(List<ConsultaModel> consultas);

}
