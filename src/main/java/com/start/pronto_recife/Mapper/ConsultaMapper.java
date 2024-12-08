package com.start.pronto_recife.Mapper;

import com.start.pronto_recife.DTOs.DTOConsulta;
import com.start.pronto_recife.DTOs.DTOConsultaRequest;
import com.start.pronto_recife.Models.ConsultaModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {

    ConsultaModel toModel(DTOConsulta dtoconsulta);
    ConsultaModel toModel(DTOConsultaRequest dtoconsulta);
    DTOConsulta toDTO(ConsultaModel consultaModel);
    DTOConsulta toDTO(DTOConsultaRequest historicoModel);
    List<DTOConsulta> listModeltoListDTO(List<ConsultaModel> consultas);

}
